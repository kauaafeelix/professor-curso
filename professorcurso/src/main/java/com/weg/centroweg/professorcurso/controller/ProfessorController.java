package com.weg.centroweg.professorcurso.controller;

import com.weg.centroweg.professorcurso.app.dto.professor.ProfessorRequestDto;
import com.weg.centroweg.professorcurso.app.dto.professor.ProfessorResponseDto;
import com.weg.centroweg.professorcurso.app.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> save (@Valid @RequestBody ProfessorRequestDto request){
        ProfessorResponseDto response = service.criarProfessor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> findById (@PathVariable Long id){
        ProfessorResponseDto response = service.buscarProfessorPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> findAll (){
        List<ProfessorResponseDto> response = service.listarProfessores();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> update (
            @PathVariable Long id,
            @Valid @RequestBody ProfessorRequestDto request
    ){
        ProfessorResponseDto response = service.atualizarProfessor(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }

}
