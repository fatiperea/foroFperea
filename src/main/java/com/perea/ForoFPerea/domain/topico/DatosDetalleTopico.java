package com.perea.ForoFPerea.domain.topico;

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
