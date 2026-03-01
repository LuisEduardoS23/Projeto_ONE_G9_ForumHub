package br.com.luisEduardo.ForumHub.dto.respostaDTOS;

import java.time.LocalDate;

public record DadosDetalhamentoResposta (

        Long id,
        String mensagem,
        LocalDate datacriacao,
        String solucao,
        Long idUsuario,
        Long idTopico

){
}
