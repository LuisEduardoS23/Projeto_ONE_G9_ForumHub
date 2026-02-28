package br.com.luisEduardo.ForumHub.validations.topico;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import br.com.luisEduardo.ForumHub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarIdDoUsuarioRealcionadoAoTopico implements IvalidacaoTopico{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DadosCadastroTopico dados) {
        var usuarioComIdPassado = usuarioRepository.findUsuarioById(dados.idUsuario());

        if(usuarioComIdPassado.isEmpty()){
            throw new ValidacaoException("Usuario com ID passado não existe!");
        }

    }
}
