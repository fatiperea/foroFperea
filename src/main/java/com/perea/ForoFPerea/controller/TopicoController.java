package com.perea.ForoFPerea.controller;

import com.perea.ForoFPerea.autor.Autor;
import com.perea.ForoFPerea.curso.Curso;
import com.perea.ForoFPerea.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){

        var topico= new Topico(datos);
        topicoRepository.save(topico);
        var uri= uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        topicoRepository.save(new Topico(datos));
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<List<DatosListaTopico>> listar(){

        List<DatosListaTopico> listaTopicos= topicoRepository.findAll().stream()
                .map(topico -> {
                    Autor autor = topico.getAutor() != null ? topico.getAutor() : new Autor("Desconocido", "N/A", "", "USER");
                    Curso curso = topico.getCurso() != null ? topico.getCurso() : new Curso("Sin curso", "PROGRAMACION");

                    return new DatosListaTopico(

                            topico.getId(),
                            topico.getTitulo(),
                            topico.getMensaje(),
                            topico.getFechaCreacion(),
                            topico.getStatus(),
                            autor.getNombre(),
                            curso.getNombre()
                    );
                })
                .toList();

        return ResponseEntity.ok(listaTopicos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallar(@PathVariable Long id) {

        Optional<Topico> topicoPrueba = topicoRepository.findById(id);

        if (topicoPrueba.isEmpty()) {
            throw new RuntimeException("Tópico con ID " + id + " no encontrado.");
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var topico = topicoRepository.getReferenceById(id);
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@PathVariable Long id,@RequestBody @Valid DatosActualizarTopico datos){

        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Topico topicoActual = topico.get();

        if (datos.titulo() == null && datos.mensaje() == null && datos.status() == null) {
            return ResponseEntity.badRequest().build();
        }

        topicoActual.actualizarInfo(datos);
        return ResponseEntity.ok(new DatosDetalleTopico(topicoActual));

    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){

        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico no encontrado");
            topicoRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }


}
