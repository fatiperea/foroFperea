package com.perea.ForoFPerea.topico;

import com.perea.ForoFPerea.autor.DatosAutor;
import com.perea.ForoFPerea.curso.DatosCurso;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico  status,
        DatosAutor autor,
        DatosCurso curso
) {
}
