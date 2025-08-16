package com.perea.ForoFPerea.topico;

public record DatosRegistroTopico(

        Long id,
        String título,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor
        //Curso curso
) {
}
