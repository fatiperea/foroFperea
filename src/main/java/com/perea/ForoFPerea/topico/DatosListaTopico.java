package com.perea.ForoFPerea.topico;

import com.perea.ForoFPerea.autor.Autor;
import com.perea.ForoFPerea.curso.Curso;

import java.time.LocalDateTime;

public record DatosListaTopico(

        String titulo,
        String mensaje,
        LocalDateTime fechaCreación,
        StatusTopico status,
        Autor autor,
        Curso curso
) {

    public DatosListaTopico(Topico topico){

        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );

    }

}
