package com.weg.centroweg.professorcurso.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String especialidade;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Curso> cursos;

     public Professor(String nome, String email, String especialidade) {
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
    }
}
