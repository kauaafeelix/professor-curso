package com.weg.centroweg.professorcurso.app.service;

import com.weg.centroweg.professorcurso.app.dto.curso.CursoRequestDto;
import com.weg.centroweg.professorcurso.app.dto.curso.CursoResponseDto;
import com.weg.centroweg.professorcurso.app.mapper.CursoMapper;
import com.weg.centroweg.professorcurso.domain.entity.Curso;
import com.weg.centroweg.professorcurso.domain.entity.Professor;
import com.weg.centroweg.professorcurso.domain.repository.CursoRepository;
import com.weg.centroweg.professorcurso.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    private final ProfessorRepository repository;


    public CursoResponseDto criarCurso(CursoRequestDto request){

        Professor professor = repository.findById(request.professorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Curso curso = cursoMapper.toEntity(request);

        curso.setProfessor(professor);

        cursoRepository.save(curso);

        return cursoMapper.toDto(curso);
    }

    public CursoResponseDto buscarCursoPorId(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        return cursoMapper.toDto(curso);
    }

    public List<CursoResponseDto> buscarCursosPorProfessorId(Long professorId){
        List<Curso> cursos = cursoRepository.findByProfessorId(professorId);

        return cursos.stream().map(cursoMapper::toDto).toList();
    }

    public List<CursoResponseDto> buscarCursosPorProfessorNome(String professorNome){
        List<Curso> cursos = cursoRepository.findByProfessor_Nome(professorNome);

        return cursos.stream().map(cursoMapper::toDto).toList();
    }

    public CursoResponseDto buscarCursoPorIdENome(Long id, String nome){
        Curso curso = cursoRepository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        return cursoMapper.toDto(curso);
    }

    public CursoResponseDto atualizarCurso(Long id, CursoRequestDto request){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Professor professor = repository.findById(request.professorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        curso.setNome(request.nome());
        curso.setProfessor(professor);

        cursoRepository.save(curso);

        return cursoMapper.toDto(curso);
    }

    public void deletarCurso(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        cursoRepository.delete(curso);
    }
}
