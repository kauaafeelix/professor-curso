package com.weg.centroweg.professorcurso.controller;

import com.weg.centroweg.professorcurso.app.dto.curso.CursoRequestDto;
import com.weg.centroweg.professorcurso.app.dto.curso.CursoResponseDto;
import com.weg.centroweg.professorcurso.app.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cursos")

public class CursoController {

    private final CursoService service;

    @PostMapping
    public ResponseEntity<CursoResponseDto> save (@Valid @RequestBody CursoRequestDto request){

        CursoResponseDto response = service.criarCurso(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> findById (@PathVariable Long id) {
        CursoResponseDto response = service.buscarCursoPorId(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/professores/id/{professorId}")
    public ResponseEntity<List<CursoResponseDto>> findByProfessorId (@PathVariable Long professorId) {

        List<CursoResponseDto> response = service.buscarCursosPorProfessorId(professorId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/professores/nome/{professorNome}")
    public ResponseEntity<List<CursoResponseDto>> findByProfessorNome (@PathVariable String professorNome) {
        List<CursoResponseDto> response = service.buscarCursosPorProfessorNome(professorNome);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<CursoResponseDto> findByIdAndNome(
            @RequestParam Long id,
            @RequestParam String nome
    ){
        CursoResponseDto response = service.buscarCursoPorIdENome(id, nome);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> update (
            @PathVariable Long id,
            @Valid @RequestBody CursoRequestDto request
    ){
        CursoResponseDto response = service.atualizarCurso(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.deletarCurso(id);

        return ResponseEntity.noContent().build();
    }
}
