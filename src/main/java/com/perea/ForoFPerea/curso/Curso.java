package com.perea.ForoFPerea.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "nombre", column = @Column(name = "curso_nombre")),
        @AttributeOverride(name = "categoria", column = @Column(name = "curso_categoria"))
})
public class Curso {

    //private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    //public Curso(){}

    public Curso(DatosCurso curso) {
        this.nombre=curso.nombre();
        this.categoria=curso.categoria();
    }
}
