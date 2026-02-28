package br.com.luisEduardo.ForumHub.dto.respostaDTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroResposta (

        @NotNull
        Long idTopico,

        @NotBlank
        String mensagem,

        @NotBlank
        String solucao
){
}
