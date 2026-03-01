package br.com.luisEduardo.ForumHub.dto.respostaDTOS;

import br.com.luisEduardo.ForumHub.model.Resposta;

import java.time.LocalDate;

public record DadosDetalhamentoResposta (

        Long id,
        String mensagem,
        LocalDate datacriacao,
        String solucao,
        Long idUsuario,
        String nomeUsuario,
        Long idTopico,
        String tituloTopico

){

    public DadosDetalhamentoResposta (Resposta resposta){
        this(
          resposta.getId(),
          resposta.getMensagem(),
          resposta.getDatacriacao(),
          resposta.getSolucao(),
          resposta.getUsuario().getId(),
          resposta.getUsuario().getNome(),
          resposta.getTopico().getId(),
          resposta.getTopico().getTitulo()
        );
    }
}
