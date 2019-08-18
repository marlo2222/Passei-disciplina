package com.trabalho.diciplina.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semestre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Semestre {

    @Id
    @Column(name = "semestre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nomeSemestre", nullable = false, length = 50)
    private String nomeSemestre;

    /*@OneToMany(mappedBy = "semestre", fetch = FetchType.EAGER)
    private List<Disciplina> disciplina;*/



}
