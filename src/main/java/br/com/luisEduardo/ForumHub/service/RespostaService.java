package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosCadastroResposta;
import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosRetornoCadastroResposta;
import br.com.luisEduardo.ForumHub.model.Resposta;
import br.com.luisEduardo.ForumHub.repository.RespostaRepository;
import br.com.luisEduardo.ForumHub.repository.TopicoRepository;
import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public DadosRetornoCadastroResposta cadastrarResposta(DadosCadastroResposta dados) {
        //validacoes aqui
        var topicoDaResposta = topicoRepository.getReferenceById(dados.idTopico());
        var usuarioDaResposta = usuarioRepository.getReferenceById(dados.idUsuario());
        var resposta = new Resposta(dados, topicoDaResposta, usuarioDaResposta);
        repository.save(resposta);
        return new DadosRetornoCadastroResposta(resposta);
    }

}
