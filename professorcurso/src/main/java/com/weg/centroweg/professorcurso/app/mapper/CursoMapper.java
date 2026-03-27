package com.weg.centroweg.professorcurso.app.mapper;

import com.weg.centroweg.professorcurso.app.dto.curso.CursoRequestDto;
import com.weg.centroweg.professorcurso.app.dto.curso.CursoResponseDto;
import com.weg.centroweg.professorcurso.domain.entity.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso toEntity (CursoRequestDto request){
        return new Curso(
                request.nome()
        );
    }

    public CursoResponseDto toDto (Curso curso){
        return new CursoResponseDto(
                curso.getId(),
                curso.getNome(),
                curso.getProfessor().getNome()
        );
    }
}
