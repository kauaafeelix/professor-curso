package com.weg.centroweg.professorcurso.app.dto.professor;


import com.weg.centroweg.professorcurso.app.dto.curso.CursoResponseDto;

import java.util.List;

public record ProfessorResponseDto(
        Long id,
        String nome,
        String email,
        String especialidade,
        List<CursoResponseDto>cursos

) {
}
