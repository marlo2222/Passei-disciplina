package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Curso;
import com.trabalho.diciplina.models.Disciplina;


import com.trabalho.diciplina.repository.CursoRepository;
import com.trabalho.diciplina.repository.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API de disciplinas")
@CrossOrigin(origins = "*/")
public class DisciplinaController {
	
	@Autowired
    DisciplinaRepository diciplinaRepository;
    @Autowired
	CursoRepository cursoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
    	return "Pagina Inicial";
    }

    @RequestMapping(value = "/disciplina/listar", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de usuarios")
    public ResponseEntity<?> listarDisciplinas(){
    	return new ResponseEntity<>(diciplinaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/disciplina/listar/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma diciplina pelo ID")
    public ResponseEntity<?> listaDisciplinaId(@PathVariable("id") long id){
		return new ResponseEntity<>(diciplinaRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/disciplina/salvar", method = RequestMethod.POST)
    @ApiOperation(value = "Salva uma disciplina")
    public ResponseEntity<?> salvarDisciplina(@RequestBody Disciplina disciplina){
        Curso curso = cursoRepository.findById(disciplina.getCurso().getId());
        disciplina.setCurso(curso);
        return new ResponseEntity<>(diciplinaRepository.save(disciplina), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/disciplina/deletar/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta uma disciplina")
    public ResponseEntity<?> apagarDisciplina(@PathVariable("id") long id){
        diciplinaRepository.deleteById(id);
        return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
    }

    @RequestMapping(value = "/disciplina/atualizar", method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza uma disciplina")
    public ResponseEntity<?> atualizarDisciplina(@RequestBody Disciplina disciplina){
    	return new ResponseEntity<>(diciplinaRepository.save(disciplina),HttpStatus.OK);
    }
}
