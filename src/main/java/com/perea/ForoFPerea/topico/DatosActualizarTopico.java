package com.perea.ForoFPerea.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(

        @NotNull Long id,
        String titulo,
        String mensaje,
        StatusTopico status

) {
}
