package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Curso;
import com.trabalho.diciplina.repository.CursoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API de cursos")
@CrossOrigin(value = "*/")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de cursos")
    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    @RequestMapping(value = "/curso/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma curso pelo id")
    public Curso listarCursoId(@PathVariable("id") long id){
        return cursoRepository.findById(id);
    }

    /*@RequestMapping(value = "/curso/{nome}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna um curso pelo nome")
    public Curso CursorNome(@PathVariable("nome") String nome){
        return cursoRepository.findByNome(nome);
    }*/

    @RequestMapping(value = "/curso", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um Curso")
    public Curso salvarCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @RequestMapping(value = "/curso/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um curso pelo id")
    public ResponseEntity.BodyBuilder deletarCurso(@PathVariable("id") long id){
        cursoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @RequestMapping(value = "/curso", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um vurso")
    public ResponseEntity.BodyBuilder deletarCurso(@RequestBody Curso curso){
        cursoRepository.delete(curso);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @RequestMapping(value = "/curso", method = RequestMethod.PUT)
    public Curso atualizarCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }
}
