package com.trabalho.diciplina.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String nome;

    private int qtdSesmestres;

    /*chave estrangeira do mapeamento esra em semestre*/
}
