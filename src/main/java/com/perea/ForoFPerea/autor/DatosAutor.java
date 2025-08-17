package com.perea.ForoFPerea.autor;

import com.perea.ForoFPerea.topico.StatusTopico;

import java.time.LocalDateTime;

public record DatosAutor(

        String nombre,
         String email,
         String password,
         Perfil perfil

) {
}
