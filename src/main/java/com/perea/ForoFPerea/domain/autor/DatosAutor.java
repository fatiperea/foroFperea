package com.perea.ForoFPerea.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public record DatosAutor(

        @NotBlank String nombre,
        @NotBlank @Email String email,
         String password,
        @NotNull Perfil perfil

) {
}
