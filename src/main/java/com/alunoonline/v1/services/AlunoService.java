package com.alunoonline.v1.services;

import com.alunoonline.v1.models.Aluno;
import com.alunoonline.v1.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }
}
