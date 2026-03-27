package com.weg.centroweg.professorcurso.app.mapper;

import com.weg.centroweg.professorcurso.app.dto.professor.ProfessorRequestDto;
import com.weg.centroweg.professorcurso.app.dto.professor.ProfessorResponseDto;
import com.weg.centroweg.professorcurso.domain.entity.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfessorMapper {

    private final CursoMapper cursoMapper;

    public Professor toEntity (ProfessorRequestDto request){
        return new Professor(
                request.nome(),
                request.email(),
                request.especialidade()
        );
    }

    public ProfessorResponseDto toDto (Professor professor){
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getEspecialidade(),
                professor.getCursos().stream().map(cursoMapper::toDto).toList()
        );
    }
}
