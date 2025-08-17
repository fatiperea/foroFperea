package com.perea.ForoFPerea.autor;

import com.perea.ForoFPerea.topico.StatusTopico;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosAutor(

        @NotBlank String nombre,
        @NotBlank @Email String email,
         String password,
         Perfil perfil

) {
}
