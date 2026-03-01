package br.com.luisEduardo.ForumHub.dto.cursoDTOS;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosDetalhamentoTopico;

import java.util.List;

public record DadosDetalhamentoCurso (

        Long id,
        String nome,
        String categoria,
        List<DadosDetalhamentoTopico> topicos

){
}
