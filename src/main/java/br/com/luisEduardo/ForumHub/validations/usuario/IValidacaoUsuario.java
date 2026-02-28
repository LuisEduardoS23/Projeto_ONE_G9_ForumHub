package br.com.luisEduardo.ForumHub.validations.usuario;

import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosCadastroUsuario;

public interface IValidacaoUsuario {

    void validar(DadosCadastroUsuario dados);
}
