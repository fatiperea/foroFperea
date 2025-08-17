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
    private Autor autor;
    @Embedded
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
                datos.autor().perfil()
        );

        this.curso = new Curso(
                datos.curso().nombre(),
                datos.curso().categoria()
        );

    }
}
