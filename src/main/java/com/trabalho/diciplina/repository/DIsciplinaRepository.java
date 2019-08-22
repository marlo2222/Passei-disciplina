package com.trabalho.diciplina.repository;

import com.trabalho.diciplina.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DIsciplinaRepository extends JpaRepository<Disciplina, Long> {
}
