package br.com.luisEduardo.ForumHub.dto.topicoDTOS;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosDetalhamentoResposta;
import java.util.List;

public record DadosDetalhamentoTopico(

        Long id,
        String titulo,
        String mensagem,
        boolean status,
        List<DadosDetalhamentoResposta> respostas,
        Long idUsuario,
        Long idCurso
) {
}
