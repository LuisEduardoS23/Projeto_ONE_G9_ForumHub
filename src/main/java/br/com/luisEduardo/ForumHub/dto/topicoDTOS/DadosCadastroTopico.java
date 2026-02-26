package br.com.luisEduardo.ForumHub.dto.topicoDTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico (
        @NotNull(message = "É preciso especificar o id do usuário")
        Long idUsuario,

        @NotNull(message = "É preciso especificar o id do curso")
        Long idCurso,

        @NotBlank(message = "O título do tópico não deve ser nulo ou estar em branco!")
        String titulo,

        @NotBlank(message = "A mensagem do tópico não deve ser nula ou estar em branco!")
        String mensagem
) {

}
