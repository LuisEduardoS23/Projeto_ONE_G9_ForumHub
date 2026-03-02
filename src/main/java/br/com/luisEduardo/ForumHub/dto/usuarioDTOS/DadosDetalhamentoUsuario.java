package br.com.luisEduardo.ForumHub.dto.usuarioDTOS;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosDetalhamentoResposta;
import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosDetalhamentoTopico;
import br.com.luisEduardo.ForumHub.model.Resposta;
import br.com.luisEduardo.ForumHub.model.Topico;
import br.com.luisEduardo.ForumHub.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhamentoUsuario(
        Long id,
        String nome,
        String email,
        List<DadosDetalhamentoTopico> topicos,
        List<DadosDetalhamentoResposta> respostas

) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTopicos().stream().filter(Topico::isStatus).map(DadosDetalhamentoTopico::new).collect(Collectors.toList()),
                usuario.getRespostas().stream().filter(Resposta::isAtivo).map(DadosDetalhamentoResposta::new).collect(Collectors.toList())
                );
    }
}
