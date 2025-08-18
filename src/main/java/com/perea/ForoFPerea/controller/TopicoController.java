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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public void registar(@RequestBody @Valid DatosRegistroTopico datos){

        //System.out.println(datos);
        topicoRepository.save(new Topico(datos));

    }

    @GetMapping
    public List<DatosListaTopico> listar(){

        return topicoRepository.findAll().stream()
               /* .peek(topico -> {
                    System.out.println("Curso: " + topico.getCurso());
                    System.out.println("Categoría: " + topico.getCurso().getCategoria());
                })*/
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
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallar(@PathVariable Long id) {

        var topico = topicoRepository.getReferenceById(id);
        System.out.println("Curso: " + topico.getCurso());
        System.out.println("Categoría: " + topico.getCurso().getCategoria());
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping
    public void actualizar(@PathVariable @Valid DatosActualizarTopico datos){

        Optional<Topico> topico = topicoRepository.findById(datos.id());

        if (topico.isPresent()) {

            var topicoActualizado= topicoRepository.getReferenceById(datos.id());
            topicoActualizado.actualizarInfo(datos);

        }

        //var topico= topicoRepository.getReferenceById(datos.id());



        //return ResponseEntity.ok(new DatosActualizarTopico(topico));
    }
    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){

        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico no encontrado");
            topicoRepository.deleteById(id);
        }



    }

    //@Transactional
    //@DeleteMapping("/{id}")
    //public ResponseEntity eliminar(@PathVariable Long id) {

    //}
    /*public ResponseEntity registrar(@RequestBody @Valid DatosRegistroMedico datos, UriComponentsBuilder uriComponentsBuilder){
        //System.out.println(datos);

        var medico= new Topico(datos);
        repository.save(medico);
        var uri= uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleMedico(medico));
    }*/

}
