package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosCadastroResposta;
import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosDetalhamentoResposta;
import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosRetornoCadastroResposta;
import br.com.luisEduardo.ForumHub.model.Resposta;
import br.com.luisEduardo.ForumHub.repository.RespostaRepository;
import br.com.luisEduardo.ForumHub.repository.TopicoRepository;
import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import br.com.luisEduardo.ForumHub.validations.resposta.IValidacaoResposta;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<IValidacaoResposta> validacoes;


    @Transactional
    public DadosRetornoCadastroResposta cadastrarResposta(DadosCadastroResposta dados) {
        validacoes.forEach(v -> v.validar(dados));

        var topicoDaResposta = topicoRepository.getReferenceById(dados.idTopico());
        var usuarioDaResposta = usuarioRepository.getReferenceById(dados.idUsuario());
        var resposta = new Resposta(dados, topicoDaResposta, usuarioDaResposta);
        repository.save(resposta);
        return new DadosRetornoCadastroResposta(resposta);
    }

    public DadosDetalhamentoResposta detalharRespostaPeloId(Long id) {
            var resposta = repository.findRespostasByIdAndAtivoTrue(id);
            if(resposta.isEmpty()){
                throw new EntityNotFoundException();
            }
            if (!resposta.get().getTopico().isStatus()){
                throw new EntityNotFoundException();
            }
            return new DadosDetalhamentoResposta(resposta.get());
    }

    @Transactional
    public void deletarRespostaPeloId(Long id) {
        var resposta = repository.findRespostasByIdAndAtivoTrue(id);
        if (resposta.isEmpty()){
            throw new EntityNotFoundException();
        }
        resposta.get().deletar();
    }
}
