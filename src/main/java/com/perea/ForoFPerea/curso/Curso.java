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
public class Curso {

    //private Long id;
    private String nombreCurso;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosCurso curso) {
        this.nombreCurso=curso.nombreCurso();
        this.categoria=curso.categoria();
    }
}
