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
@AttributeOverrides({
        @AttributeOverride(name = "nombre", column = @Column(name = "autor_nombre")),
        @AttributeOverride(name = "email", column = @Column(name = "autor_email")),
        @AttributeOverride(name = "password", column = @Column(name = "autor_password")),
        @AttributeOverride(name = "perfil", column = @Column(name = "autor_perfil"))
})
public class Autor {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private String nombre;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    //public Autor(){}

    public Autor(DatosAutor autor) {

        this.nombre=autor.nombre();
        this.email=autor.email();
        this.password=autor.password();
        this.perfil=autor.perfil();

    }

    public Autor(String nombre, String email, String password, String perfil) {

        this.nombre=nombre;
        this.email=email;
        this.perfil= Perfil.valueOf(perfil);
        this.password=password;
    }
}
