package com.alunoonline.v1.matricula_aluno.services;

import com.alunoonline.v1.matricula_aluno.models.MatriculaAluno;
import com.alunoonline.v1.matricula_aluno.dtos.MatriculaAlunoNotasOnlyDto;
import com.alunoonline.v1.matricula_aluno.repositories.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class MatriculaAlunoService {

    static final Double gradesAvgToApprove = 7.0;

    @Autowired
    MatriculaAlunoRepository repository;

    public MatriculaAluno create(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus("MATRICULADO");
        return repository.save(matriculaAluno);
    }

    public void updateGrades(MatriculaAlunoNotasOnl.yDto notasOnlyDto, Long matriculaAlunoId) {

        Optional<MatriculaAluno> matriculaAlunoToUpdate = repository.findById(matriculaAlunoId);

        boolean needUpdate = false;

        if (StringUtils.hasLength(notasOnlyDto.getNota1().toString())) {
            matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setNota1(notasOnlyDto.getNota1()));
            needUpdate = true;
        }

        if (StringUtils.hasLength(notasOnlyDto.getNota1().toString())) {
            matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setNota2(notasOnlyDto.getNota2()));
            needUpdate = true;
        }

        if (needUpdate) {
            if (matriculaAlunoToUpdate.get().getNota1() != null && matriculaAlunoToUpdate.get().getNota2() != null) {
                if (matriculaAlunoToUpdate.get().getNota1() + matriculaAlunoToUpdate.get().getNota2() / 2 >= gradesAvgToApprove) {
                    matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setStatus("APROVADO"));
                } else {
                    matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setStatus("REPROVADO"));
                }

            }
            repository.save(matriculaAlunoToUpdate.get());
        }

    }



}
