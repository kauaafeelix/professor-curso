package com.weg.centroweg.professorcurso.domain.repository;

import com.weg.centroweg.professorcurso.domain.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByProfessor_Nome(String professorNome);

    List<Curso> findByProfessorId(Long professorId);

    Optional<Curso> findByIdAndNome(Long id, String nome);
}
