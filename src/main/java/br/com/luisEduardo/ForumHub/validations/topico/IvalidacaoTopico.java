package br.com.luisEduardo.ForumHub.validations.topico;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import br.com.luisEduardo.ForumHub.model.Topico;

public interface IvalidacaoTopico {

    public void validar(DadosCadastroTopico dados);
}
