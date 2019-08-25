package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Curso;
import com.trabalho.diciplina.repository.CursoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API de cursos")
@CrossOrigin(value = "*/")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @RequestMapping(value = "/curso/listar", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de cursos")
    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    @RequestMapping(value = "/curso/listar/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma curso pelo id")
    public Curso listarCursoId(@PathVariable("id") long id){
        return cursoRepository.findById(id);
    }

    @RequestMapping(value = "/curso/salvar", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um Curso")
    public Curso salvarCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @RequestMapping(value = "/curso/deletar/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um curso pelo id")
    public void deletarCurso(@PathVariable("id") long id){
        cursoRepository.deleteById(id);
    }

    @RequestMapping(value = "/curso/deletar", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um vurso")
    public void deletarCurso(@RequestBody Curso curso){
        cursoRepository.delete(curso);
    }

    @RequestMapping(value = "/curso/atualizar", method = RequestMethod.PUT)
    public Curso atualizarCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }
}
