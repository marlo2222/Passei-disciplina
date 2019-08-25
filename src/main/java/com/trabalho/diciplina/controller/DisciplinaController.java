package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Curso;
import com.trabalho.diciplina.models.Disciplina;


import com.trabalho.diciplina.repository.CursoRepository;
import com.trabalho.diciplina.repository.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Disciplina> listarDisciplinas(){
    	return diciplinaRepository.findAll();
    }

    @RequestMapping(value = "/disciplina/listar/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma diciplina pelo ID")
    public Disciplina listaDisciplinaId(@PathVariable("id") long id){
		return diciplinaRepository.findById(id);
    }

    @RequestMapping(value = "/disciplina/salvar", method = RequestMethod.POST)
    @ApiOperation(value = "Salva uma disciplina")
    public Disciplina salvarDisciplina(@RequestBody Disciplina disciplina){
        Curso curso = cursoRepository.findById(disciplina.getCurso().getId());
        disciplina.setCurso(curso);
        return diciplinaRepository.save(disciplina);
    }

    @RequestMapping(value = "/disciplina/deletar/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta uma disciplina")
    public void apagarDisciplina(@PathVariable("id") long id){
        diciplinaRepository.deleteById(id);
    }

    @RequestMapping(value = "/disciplina/atualizar", method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza uma disciplina")
    public Disciplina atualizarDisciplina(@RequestBody Disciplina disciplina){
    	return diciplinaRepository.save(disciplina);
    }
}
