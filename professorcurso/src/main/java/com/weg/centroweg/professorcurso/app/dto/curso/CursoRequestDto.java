package com.weg.centroweg.professorcurso.app.dto.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CursoRequestDto(

        @NotBlank(message = "O nome do curso é obrigatório")
        String nome,

        @Positive(message = "O ID do professor deve ser um número positivo")
        @NotNull(message = "O ID do professor é obrigatório")
        Long professorId
) {
}
