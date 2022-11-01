package com.alunoonline.v1.secretaria.repositories;

import com.alunoonline.v1.secretaria.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
