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

    @RequestMapping(value = "/curso/listar", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de cursos")
    public ResponseEntity<?> listarCursos(){
        return new ResponseEntity<>(cursoRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/curso/listar/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma curso pelo id")
    public ResponseEntity<?> listarCursoId(@PathVariable("id") long id){
        return new ResponseEntity<>(cursoRepository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/curso/salvar", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um Curso")
    public ResponseEntity<?> salvarCurso(@RequestBody Curso curso){
        return new ResponseEntity<>(cursoRepository.save(curso),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/curso/deletar/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um curso pelo id")
    public ResponseEntity<?> deletarCurso(@PathVariable("id") long id){
        cursoRepository.deleteById(id);
        return new ResponseEntity<>("Deleado com sucesso", HttpStatus.OK);
    }

    @RequestMapping(value = "/curso/deletar", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um vurso")
    public ResponseEntity<?> deletarCurso(@RequestBody Curso curso){
        cursoRepository.delete(curso);
        return new ResponseEntity<>("Deletado com Sucesso", HttpStatus.OK);
    }

    @RequestMapping(value = "/curso/atualizar", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarCurso(@RequestBody Curso curso){
        return new ResponseEntity<>(cursoRepository.save(curso), HttpStatus.OK);
    }
}
