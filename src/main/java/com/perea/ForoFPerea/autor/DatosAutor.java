package com.perea.ForoFPerea.autor;

import com.perea.ForoFPerea.topico.StatusTopico;

import java.time.LocalDateTime;

public record DatosAutor(

        LocalDateTime fechaCreacion,
        StatusTopico status,
        DatosAutor autor

) {
}
