package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosCadastroResposta;
import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosRetornoCadastroResposta;
import br.com.luisEduardo.ForumHub.model.Resposta;
import br.com.luisEduardo.ForumHub.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private TopicoService topicoService;



    public DadosRetornoCadastroResposta cadastrarResposta(DadosCadastroResposta dados) {
        //validacoes aqui
        var topicoDaResposta = topicoService.buscarTopicoPorId(dados.idTopico());
        var resposta = new Resposta(dados, topicoDaResposta);
        repository.save(resposta);
        return new DadosRetornoCadastroResposta(resposta);
    }

}
