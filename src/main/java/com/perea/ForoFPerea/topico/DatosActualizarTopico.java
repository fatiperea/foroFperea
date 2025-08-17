package com.perea.ForoFPerea.topico;

import java.time.LocalDateTime;

public record DatosActualizarTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreación,
        StatusTopico status,
        String autorNombre,
        String cursoNombre

) {
}
