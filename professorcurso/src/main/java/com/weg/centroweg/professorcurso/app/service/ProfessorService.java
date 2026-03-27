package com.weg.centroweg.professorcurso.app.service;

import com.weg.centroweg.professorcurso.app.dto.professor.ProfessorRequestDto;
import com.weg.centroweg.professorcurso.app.dto.professor.ProfessorResponseDto;
import com.weg.centroweg.professorcurso.app.mapper.ProfessorMapper;
import com.weg.centroweg.professorcurso.domain.entity.Professor;
import com.weg.centroweg.professorcurso.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper mapper;

    public ProfessorResponseDto criarProfessor(ProfessorRequestDto request){

        Professor professor = mapper.toEntity(request);

        professorRepository.save(professor);

        return mapper.toDto(professor);
    }

    public ProfessorResponseDto buscarProfessorPorId(Long id){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        return mapper.toDto(professor);
    }

    public ProfessorResponseDto atualizarProfessor(Long id, ProfessorRequestDto request){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        professor.setNome(request.nome());
        professor.setEmail(request.email());
        professor.setEspecialidade(request.especialidade());

        professorRepository.save(professor);

        return mapper.toDto(professor);
    }

    public void deletarProfessor(Long id){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professorRepository.delete(professor);
    }
}
