package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Curso;
import com.trabalho.diciplina.models.Disciplina;


import com.trabalho.diciplina.repository.CursoRepository;
import com.trabalho.diciplina.repository.DisciplinaRepository;
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
	
	@Autowired
    DisciplinaRepository diciplinaRepository;
    @Autowired
	CursoRepository cursoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
    	return "Pagina Inicial";
    }
    @RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de usuarios")
    public List<Disciplina> listarDisciplinas(){
    	return diciplinaRepository.findAll();
    }

    @RequestMapping(value = "/disciplina/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma diciplina pelo ID")
    public Disciplina listaDisciplinaId(@PathVariable("id") long id){

		return diciplinaRepository.getOne(id);
    }

    @RequestMapping(value = "/disciplina/{nome}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma diciplina pelo NOME")
    public Disciplina listerDisciplineNome(@PathVariable("nome") String nome){
    	return diciplinaRepository.findByNome(nome);
    }

    @RequestMapping(value = "/disciplina", method = RequestMethod.POST)
    @ApiOperation(value = "Salva uma disciplina")
    public Disciplina salvarDisciplina(@RequestBody Disciplina disciplina){
        Curso curso = cursoRepository.findById(disciplina.getCurso().getId());
        disciplina.setCurso(curso);
        return diciplinaRepository.save(disciplina);
    }

    @RequestMapping(value = "/disciplina/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta uma disciplina")
    public ResponseEntity.BodyBuilder apagarDisciplina(@PathVariable("id") long id){
        diciplinaRepository.deleteById(id);
    	return ResponseEntity.status(HttpStatus.OK);
    }

    @RequestMapping(value = "/disciplina", method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza uma disciplina")
    public Disciplina atualizarDisciplina(@RequestBody Disciplina disciplina){
    	return diciplinaRepository.save(disciplina);
    }

}
