package com.alunoonline.v1.aluno.services;

import com.alunoonline.v1.aluno.models.MatriculaAluno;
import com.alunoonline.v1.aluno.repositories.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository repository;

    public MatriculaAluno create(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus("MATRICULADO");
        return repository.save(matriculaAluno);
    }

}
