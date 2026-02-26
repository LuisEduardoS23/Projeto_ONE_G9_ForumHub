package br.com.luisEduardo.ForumHub.dto.cursoDTOS;

import br.com.luisEduardo.ForumHub.model.Curso;

public record DadosRetornoCadastroCurso(Long id, String nome, String categoria) {
    public DadosRetornoCadastroCurso(Curso curso) {
        this(curso.getId(),curso.getNome(),curso.getCategoria());
    }
}
