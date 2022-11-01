package com.alunoonline.v1.secretaria.services;

import com.alunoonline.v1.secretaria.models.Professor;
import com.alunoonline.v1.secretaria.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create(Professor professor) {
        return repository.save(professor);
    }
}
