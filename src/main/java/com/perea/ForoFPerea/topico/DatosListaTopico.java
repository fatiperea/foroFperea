package com.perea.ForoFPerea.topico;

import com.perea.ForoFPerea.autor.Autor;
import com.perea.ForoFPerea.curso.Curso;

import java.time.LocalDateTime;

public record DatosListaTopico(

        String titulo,
        String mensaje,
        LocalDateTime fechaCreación,
        StatusTopico status,
        String autorNombre,
        String cursoNombre
) {

    public DatosListaTopico(Topico topico){

        /*this.titulo=topico.getTitulo();
        this.mensaje=topico.getMensaje();
        this.fechaCreación=topico.getFechaCreacion();
        this.status=topico.getStatus();
        this.autor=topico.getAutor();
        this.curso=topico.getCurso();*/
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );

    }

}
