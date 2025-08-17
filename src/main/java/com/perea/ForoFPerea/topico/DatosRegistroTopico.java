package com.perea.ForoFPerea.topico;

import com.perea.ForoFPerea.autor.DatosAutor;
import com.perea.ForoFPerea.curso.DatosCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

        //Long id,
        @NotBlank String titulo,//eleji las q dicen hibernate
        @NotBlank String mensaje,
        @NotNull LocalDateTime fechaCreacion,
        @NotNull StatusTopico  status,
        @NotNull @Valid DatosAutor autor,
        @NotNull @Valid DatosCurso curso
) {
}
