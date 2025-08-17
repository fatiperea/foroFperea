package com.perea.ForoFPerea.topico;

import com.perea.ForoFPerea.autor.Autor;
import com.perea.ForoFPerea.curso.Curso;

import java.time.LocalDateTime;

public record DatosListaTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreación,
        StatusTopico status,
        String autorNombre,
        String cursoNombre
) {

    public DatosListaTopico(Topico topico){

        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );

    }

}
