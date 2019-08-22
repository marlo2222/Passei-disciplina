package com.trabalho.diciplina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalho.diciplina.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findById(long id);

    Curso findByNome(String nome);
}
