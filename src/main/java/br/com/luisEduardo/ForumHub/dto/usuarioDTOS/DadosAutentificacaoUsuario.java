package br.com.luisEduardo.ForumHub.dto.usuarioDTOS;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAutentificacaoUsuario(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha
        ) {
}
