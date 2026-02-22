package br.com.luisEduardo.ForumHub.dto.cursoDTOS;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(

        @NotBlank
        String nome,

        @NotBlank
        String categoria
) {
}
