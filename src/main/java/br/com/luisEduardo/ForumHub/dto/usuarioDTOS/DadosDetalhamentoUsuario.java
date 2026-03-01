package br.com.luisEduardo.ForumHub.dto.usuarioDTOS;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosDetalhamentoResposta;
import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosDetalhamentoTopico;

import java.util.List;

public record DadosDetalhamentoUsuario(
        Long id,
        String nome,
        String email,
        List<DadosDetalhamentoTopico> topicos,
        List<DadosDetalhamentoResposta> respostas

) {
}
