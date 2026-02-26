package br.com.luisEduardo.ForumHub.dto.usuarioDTOS;

import br.com.luisEduardo.ForumHub.model.Usuario;

public record DadosRetornoCadastroUsuario(Long id, String nome, String email) {
    public DadosRetornoCadastroUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
