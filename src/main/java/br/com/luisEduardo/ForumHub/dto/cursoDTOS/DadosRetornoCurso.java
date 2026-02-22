package br.com.luisEduardo.ForumHub.dto.cursoDTOS;

import br.com.luisEduardo.ForumHub.model.Curso;
import jakarta.validation.constraints.NotBlank;

public record DadosRetornoCurso(Long id,String nome, String categoria) {
    public DadosRetornoCurso(Curso curso) {
        this(curso.getId(),curso.getNome(),curso.getCategoria());
    }
}
