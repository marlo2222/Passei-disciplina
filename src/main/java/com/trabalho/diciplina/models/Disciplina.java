package com.trabalho.diciplina.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "disciplina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", unique = true, length = 50)
    private String nome;

    @Column(name = "professorAtual",length = 50)
    private String professorAtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_curso")
    @JsonIgnore
    private Curso curso;
}
