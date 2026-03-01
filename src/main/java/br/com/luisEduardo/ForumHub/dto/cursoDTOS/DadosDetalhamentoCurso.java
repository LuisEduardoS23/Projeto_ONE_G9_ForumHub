package br.com.luisEduardo.ForumHub.dto.cursoDTOS;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosDetalhamentoTopico;
import br.com.luisEduardo.ForumHub.model.Curso;

import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhamentoCurso (

        Long id,
        String nome,
        String categoria,
        List<DadosDetalhamentoTopico> topicos

){
    public DadosDetalhamentoCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getCategoria(),
                curso.getTopicos().stream().map(DadosDetalhamentoTopico::new).collect(Collectors.toList())
        );
    }
}
