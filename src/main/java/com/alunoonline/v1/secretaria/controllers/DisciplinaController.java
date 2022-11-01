package com.alunoonline.v1.secretaria.controllers;

import com.alunoonline.v1.secretaria.models.Disciplina;
import com.alunoonline.v1.secretaria.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina disciplina) {
        Disciplina disciplinaCreated = service.create(disciplina);

        return ResponseEntity.status(201).body(disciplinaCreated);
    }
}
