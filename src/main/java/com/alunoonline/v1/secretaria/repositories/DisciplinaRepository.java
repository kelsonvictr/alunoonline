package com.alunoonline.v1.secretaria.repositories;

import com.alunoonline.v1.secretaria.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
