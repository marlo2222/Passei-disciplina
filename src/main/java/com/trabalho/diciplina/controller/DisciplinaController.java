package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Disciplina;
import com.trabalho.diciplina.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
    @RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
    public List<Disciplina> listarDisciplinas(){
    	return disciplinaRepository.findAll();
    }

    @RequestMapping(value = "/disciplina/{id}", method = RequestMethod.GET)
    public Disciplina listaDisciplinaId(@PathVariable("id") long id){
    	return disciplinaRepository.getOne(id);
    }

    @RequestMapping(value = "/disciplina/{nome}", method = RequestMethod.GET)
    public Disciplina listarDisciplinaNome(@PathVariable("nome") String nome){
    	return disciplinaRepository.findByNome(nome);
    }

    @RequestMapping(value = "/disciplina", method = RequestMethod.POST)
    public Disciplina salvarDisciplina(Disciplina disciplina){
    	return disciplinaRepository.save(disciplina);
    }

    @RequestMapping(value = "/disciplina/{id}", method = RequestMethod.DELETE)
    public ResponseEntity.BodyBuilder apagarDisciplina(@PathVariable("id") long id){
        disciplinaRepository.deleteById(id);
    	return ResponseEntity.status(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/disciplina", method = RequestMethod.PUT)
    public Disciplina atualizarDisciplina(Disciplina disciplina){
    	return disciplinaRepository.save(disciplina);
    }

}
