package br.com.luisEduardo.ForumHub.dto.topicoDTOS;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosDetalhamentoResposta;
import br.com.luisEduardo.ForumHub.model.Topico;

import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhamentoTopico(

        Long id,
        String titulo,
        String mensagem,
        boolean status,
        List<DadosDetalhamentoResposta> respostas,
        Long idUsuario,
        String nomeUsuario,
        Long idCurso,
        String nomeCurso
) {


    public DadosDetalhamentoTopico(Topico topico) {
        this(
              topico.getId(),
              topico.getTitulo(),
              topico.getMensagem(),
              topico.isStatus(),
              topico.getRespostas().stream().map(DadosDetalhamentoResposta::new).collect(Collectors.toList()),
              topico.getUsuario().getId(),
              topico.getUsuario().getNome(),
              topico.getCurso().getId(),
              topico.getCurso().getNome()
        );
    }

}
