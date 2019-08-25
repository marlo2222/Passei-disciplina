package com.trabalho.diciplina.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "qtd_semestres")
    private int qtdSesmestres;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference
    public List<Disciplina> disciplinas;
}
