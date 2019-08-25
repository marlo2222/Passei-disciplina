package com.trabalho.diciplina.repository;

import com.trabalho.diciplina.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    Disciplina findByNome(String nome);

    Disciplina findById(long id);
}
