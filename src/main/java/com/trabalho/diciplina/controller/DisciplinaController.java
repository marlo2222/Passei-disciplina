package com.trabalho.diciplina.controller;

import com.trabalho.diciplina.models.Disciplina;
import com.trabalho.diciplina.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    /*
    @RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
    public List<Disciplina> listarDisciplinas(){

    }

    @RequestMapping(value = "/disciplina/{id}", method = RequestMethod.GET)
    public Disciplina listaDisciplinaId(){

    }

    @RequestMapping(value = "/disciplina/{nome}", method = RequestMethod.GET)
    public Disciplina listarDisciplinaNome(){

    }

    @RequestMapping(value = "/disciplina", method = RequestMethod.POST)
    public Disciplina salvarDisciplina(){

    }

    @RequestMapping(value = "/disciplina", method = RequestMethod.DELETE)
    public ResponseEntity.BodyBuilder apagarDisciplina(){
        return ResponseEntity.status(HttpStatus.OK);
    }*/

}
