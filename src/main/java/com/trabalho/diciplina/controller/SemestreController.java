package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Semestre;
import com.trabalho.diciplina.repository.SemestreRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API de semestres")
@CrossOrigin(origins = "*/")
public class SemestreController {

    @Autowired
    SemestreRepository semestreRepository;

    @RequestMapping(value = "/semestres", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna uma lista de semestres")
    public List<Semestre> listarSemestre(){
        return semestreRepository.findAll();
    }

    @RequestMapping(value = "/semestre/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna um semestre pelo ID")
    public Semestre listarSemestreId(@PathVariable("id") long id){
        return semestreRepository.getOne(id);
    }

    @RequestMapping(value = "/semestre", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um semestre")
    public Semestre salvarSemestre(@RequestBody Semestre semestre){
        return semestreRepository.save(semestre);
    }

    @RequestMapping(value = "/semestre/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um semestre pelo id")
    public ResponseEntity.BodyBuilder deletarSemestre(@PathVariable("id") long id){
        semestreRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @RequestMapping(value = "/semestre", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta um semestre")
    public ResponseEntity.BodyBuilder deletarSemestre(@RequestBody Semestre semestre){
        semestreRepository.delete(semestre);
        return ResponseEntity.status(HttpStatus.OK);
    }

    @RequestMapping(value = "/semestre", method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza um semestre")
    public Semestre atualizarSemestre(@RequestBody Semestre semestre){
        return semestreRepository.save(semestre);
    }
}
