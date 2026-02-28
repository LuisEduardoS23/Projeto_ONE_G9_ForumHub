package br.com.luisEduardo.ForumHub.dto.respostaDTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroResposta (

        @NotNull(message = "O id do tópico da resposta não pode ser nulo!")
        Long idTopico,

        @NotNull(message = "O id do usuário proprietário da resposta não pode ser nulo!")
        Long idUsuario,

        @NotBlank(message = "A Mensagem da resposta não pode ser nula ou estar em branco!")
        String mensagem,

        @NotBlank(message = "A Solução da resposta não pode ser nula ou estar em branco!")
        String solucao
){
}
