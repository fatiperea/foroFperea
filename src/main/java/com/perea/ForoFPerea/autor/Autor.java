package com.perea.ForoFPerea.autor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Table(name = "autores")
@Entity(name = "Autor")*/
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Autor {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private String nombre;
    private String email;
    private String password;
    private Perfil perfil;

    //public Autor(){}

    public Autor(DatosAutor autor) {

        this.nombre=autor.nombre();
        this.email=autor.email();
        this.password=autor.password();
        this.perfil=autor.perfil();

    }
}
