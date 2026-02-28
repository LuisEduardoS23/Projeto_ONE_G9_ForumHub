package br.com.luisEduardo.ForumHub.dto.respostaDTOS;

import br.com.luisEduardo.ForumHub.model.Resposta;

import java.time.LocalDate;

public record DadosRetornoCadastroResposta(Long id, String nomeUsuario, String nomeTopico, String mensagem, String solucao, LocalDate dataCriacao) {

    public DadosRetornoCadastroResposta(Resposta resposta) {
        this(resposta.getId(), resposta.getUsuario().getNome(), resposta.getTopico().getTitulo(), resposta.getMensagem(), resposta.getSolucao(),resposta.getDatacriacao());
    }
}
