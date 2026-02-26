package br.com.luisEduardo.ForumHub.dto.usuarioDTOS;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario (
        @NotBlank(message = "O nome do usuário não deve ser nulo ou em branco!")
        String nome,

        @NotBlank(message = "O e-mail do usuário não deve ser nulo ou em branco!")
        @Email(message = "Formato de e-mail inválido!")
        String email,

        @NotBlank(message = "A senha do usuário não deve ser nula ou em branco!")
        String senha
){
}
