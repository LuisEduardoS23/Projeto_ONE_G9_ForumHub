package br.com.luisEduardo.ForumHub.validations.resposta;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosCadastroResposta;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarIdDoTopicoRelacionadoAResposta implements IValidacaoResposta{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosCadastroResposta dados) {
        var topicoComIdPassado = topicoRepository.findTopicosById(dados.idTopico());

        if(topicoComIdPassado.isEmpty()){
            throw new ValidacaoException("Topico com ID passado não existe!");
        }
    }
}
