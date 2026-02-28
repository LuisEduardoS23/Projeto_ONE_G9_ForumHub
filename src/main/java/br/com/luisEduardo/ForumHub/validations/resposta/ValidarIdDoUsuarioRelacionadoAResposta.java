package br.com.luisEduardo.ForumHub.validations.resposta;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosCadastroResposta;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarIdDoUsuarioRelacionadoAResposta implements IValidacaoResposta{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DadosCadastroResposta dados) {
        var usuarioComIDPassado = usuarioRepository.findUsuarioById(dados.idUsuario());

        if(usuarioComIDPassado.isEmpty()){
            throw new ValidacaoException("Usuario com ID passado não existe!");
        }
    }
}
