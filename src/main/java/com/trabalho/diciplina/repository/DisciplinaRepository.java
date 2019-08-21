package com.trabalho.diciplina.repository;

import com.trabalho.diciplina.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	@Query("FROM disciplina d WHERE d.nome = :nome")
    Disciplina findByNome(@Param("nome") String nome);
    
    Disciplina findById(long id);
}
