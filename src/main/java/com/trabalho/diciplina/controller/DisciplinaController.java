package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Disciplina;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API de disciplinas")
@CrossOrigin(origins = "*/")
public class DisciplinaController {
	
	/*@Autowired
	DisciplinaRepository diciplinaRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
    	return "Pagina Inicial";
    }
    @RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de usuarios")
    public List<Disciplina> listarDisciplinas(){
    	return dis
    }

    @RequestMapping(value = "/disciplina/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma diciplina pelo ID")
    public Disciplina listaDisciplinaId(@PathVariable("id") long id){
    	JpaRepository<Disciplina, Long> disciplinaRepository;
		return disciplinaRepository.getOne(id);
    }

    @RequestMapping(value = "/disciplina/{nome}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma diciplina pelo NOME")
    public Disciplina listarDisciplinaNome(@PathVariable("nome") String nome){
    	return disciplinaRepository.findByNome(nome);
    }

    @RequestMapping(value = "/disciplina", method = RequestMethod.POST)
    @ApiOperation(value = "Salva uma disciplina")
    public Disciplina salvarDisciplina(@RequestBody Disciplina disciplina){
    	return disciplinaRepository.save(disciplina);
    }

    @RequestMapping(value = "/disciplina/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta uma disciplina")
    public ResponseEntity.BodyBuilder apagarDisciplina(@PathVariable("id") long id){
        disciplinaRepository.deleteById(id);
    	return ResponseEntity.status(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/disciplina", method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza uma disciplina")
    public Disciplina atualizarDisciplina(@RequestBody Disciplina disciplina){
    	return disciplinaRepository.save(disciplina);
    }*/

}
