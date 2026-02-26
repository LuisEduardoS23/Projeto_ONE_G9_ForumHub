package br.com.luisEduardo.ForumHub.dto.topicoDTOS;

import br.com.luisEduardo.ForumHub.model.Topico;

public record DadosRetornoCadastroTopico(Long id, String nomeUsuario, String nomeCurso, String titulo, String mensagem) {

    public DadosRetornoCadastroTopico(Topico topico) {
        this(topico.getId(), topico.getUsuario().getNome(), topico.getCurso().getNome(), topico.getTitulo(), topico.getMensagem());
    }
}
