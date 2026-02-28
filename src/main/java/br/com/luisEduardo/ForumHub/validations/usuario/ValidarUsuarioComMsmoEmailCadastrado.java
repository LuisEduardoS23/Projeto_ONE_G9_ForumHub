package br.com.luisEduardo.ForumHub.validations.usuario;

import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosCadastroUsuario;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarUsuarioComMsmoEmailCadastrado implements IValidacaoUsuario{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DadosCadastroUsuario dados) {
        var usuarioComMesmoEmail = usuarioRepository.getReferenceByEmail(dados.email());

        if(usuarioComMesmoEmail.isPresent()){
            throw new ValidacaoException("Usuário com o e-mail: "+dados.email()+" já está cadastrado no sistema!");
        }
    }
}
