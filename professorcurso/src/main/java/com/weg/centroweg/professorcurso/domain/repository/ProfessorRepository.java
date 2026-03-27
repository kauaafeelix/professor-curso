package com.weg.centroweg.professorcurso.domain.repository;

import com.weg.centroweg.professorcurso.domain.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
