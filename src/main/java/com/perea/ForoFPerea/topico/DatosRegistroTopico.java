package com.perea.ForoFPerea.topico;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico  status
        //Long autorId,
        //Long curso
) {
}
