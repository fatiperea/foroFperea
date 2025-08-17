package com.perea.ForoFPerea.controller;

import com.perea.ForoFPerea.topico.DatosRegistroTopico;
import com.perea.ForoFPerea.topico.Topico;
import com.perea.ForoFPerea.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public void registar(@RequestBody DatosRegistroTopico datos){

        //System.out.println(datos);
        topicoRepository.save(new Topico(datos));

    }
    /*public ResponseEntity registrar(@RequestBody @Valid DatosRegistroMedico datos, UriComponentsBuilder uriComponentsBuilder){
        //System.out.println(datos);

        var medico= new Topico(datos);
        repository.save(medico);
        var uri= uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleMedico(medico));
    }*/

}
