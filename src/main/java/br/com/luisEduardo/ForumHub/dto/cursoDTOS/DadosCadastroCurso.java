package br.com.luisEduardo.ForumHub.dto.cursoDTOS;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(

        @NotBlank(message = "O nome do curso não pode estar vazio!")
        String nome,

        @NotBlank(message = "A categoria do curso não pode estar vazia!")
        String categoria
) {
}
