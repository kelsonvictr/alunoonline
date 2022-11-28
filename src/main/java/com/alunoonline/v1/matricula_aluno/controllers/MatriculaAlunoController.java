package com.alunoonline.v1.matricula_aluno.controllers;

import com.alunoonline.v1.matricula_aluno.dtos.HistoricoAlunoDto;
import com.alunoonline.v1.matricula_aluno.models.MatriculaAluno;
import com.alunoonline.v1.matricula_aluno.dtos.MatriculaAlunoNotasOnlyDto;
import com.alunoonline.v1.matricula_aluno.services.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaAluno> create(@RequestBody MatriculaAluno matriculaAluno) {
        MatriculaAluno matriculaAlunoCreated = service.create(matriculaAluno);

        return ResponseEntity.status(201).body(matriculaAlunoCreated);
    }

    @PatchMapping("/updateGrades/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchGrades(@RequestBody MatriculaAlunoNotasOnlyDto notasOnlyDto,
                                                @PathVariable Long id) {
         service.updateGrades(notasOnlyDto, id);
    }

    @PatchMapping("/updateStatusToBreak/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchStatus(@PathVariable Long id) throws Exception {
        service.updateStatusToBreak(id);
    }

    @GetMapping("/studentGrades/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoDto studentGrades(@PathVariable Long id) {
        return service.getHistoricoFromAluno(id);
    }


}
