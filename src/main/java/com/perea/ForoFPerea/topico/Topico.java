package com.perea.ForoFPerea.topico;

import com.perea.ForoFPerea.autor.Autor;
import com.perea.ForoFPerea.curso.Curso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private StatusTopico  status;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nombre", column = @Column(name = "autor_nombre")),
            @AttributeOverride(name = "email", column = @Column(name = "autor_email")),
            @AttributeOverride(name = "password", column = @Column(name = "autor_password")),
            @AttributeOverride(name = "perfil", column = @Column(name = "autor_perfil"))
    })
    private Autor autor;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nombre", column = @Column(name = "curso_nombre")),
            @AttributeOverride(name = "categoria", column = @Column(name = "curso_categoria"))
    })
    private Curso curso;


    public Topico(DatosRegistroTopico datos) {

        this.titulo=datos.titulo();
        this.mensaje=datos.mensaje();
        this.fechaCreacion=datos.fechaCreacion();
        this.status=datos.status();
        //this.autor= new Autor(datos.autor());
        //this.curso=new Curso(datos.curso());

        this.autor = new Autor(
                datos.autor().nombre(),
                datos.autor().email(),
                datos.autor().password(),
                datos.autor().perfil().name()
        );

        this.curso = new Curso(
                datos.curso().nombre(),
                datos.curso().categoria().name()
        );

    }

    public void actualizarInfo(@Valid DatosActualizarTopico datos) {


        if(datos.titulo() != null){

            this.titulo=datos.titulo();
        }
        if(datos.mensaje() != null){

            this.mensaje=datos.mensaje();
        }
        if(datos.fechaCreación() != null){

            this.fechaCreacion=datos.fechaCreación();
        }
        if(datos.status() != null){

            this.status=datos.status();
        }
        if(datos.autorNombre() != null){

            //this.autor.actualizarAutor(datos.);
        }
        if(datos.cursoNombre() != null){

            //this.curso=datos.cursoNombre();
        }



    }
}
