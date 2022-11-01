package com.alunoonline.v1.secretaria.controllers;

import com.alunoonline.v1.secretaria.models.Professor;
import com.alunoonline.v1.secretaria.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        Professor professorCreated = service.create(professor);

        return ResponseEntity.status(201).body(professorCreated);
    }
}
