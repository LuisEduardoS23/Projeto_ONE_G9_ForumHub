package br.com.luisEduardo.ForumHub.validations.usuario;

import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosCadastroUsuario;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import br.com.luisEduardo.ForumHub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarUsuarioComMesmoNomeCadastrado implements IValidacaoUsuario{

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void validar(DadosCadastroUsuario dados) {
        var usuarioComMesmoNome = usuarioRepository.findByNome(dados.nome());
        if (usuarioComMesmoNome.isPresent()) {
            throw new ValidacaoException("Usuario com este nome já está cadastrado no sistema!");
        }
    }
}
