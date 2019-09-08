package com.trabalho.diciplina.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @Column(name = "nome", unique = true, length = 50, nullable = false)
    @NotEmpty
    private String nome;

    @Column(name = "professorAtual",length = 50, nullable = false)
    private String professorAtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_curso")
    @JsonBackReference
    private Curso curso;
}
