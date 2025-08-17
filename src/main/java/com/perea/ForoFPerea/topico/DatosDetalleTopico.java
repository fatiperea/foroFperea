package com.perea.ForoFPerea.topico;

import com.perea.ForoFPerea.autor.DatosAutor;
import com.perea.ForoFPerea.curso.DatosCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosDetalleTopico(

        String titulo,
        String mensaje,
        LocalDateTime fechaCreación,
        StatusTopico status,
        String autorNombre,
        String cursoNombre

) {

    public DatosDetalleTopico(Topico topico){

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
