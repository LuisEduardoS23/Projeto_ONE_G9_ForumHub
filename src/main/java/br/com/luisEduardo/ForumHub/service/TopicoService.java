package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosRetornoCadastroTopico;
import br.com.luisEduardo.ForumHub.model.Curso;
import br.com.luisEduardo.ForumHub.model.Topico;
import br.com.luisEduardo.ForumHub.repository.TopicoRepository;
import br.com.luisEduardo.ForumHub.validations.topico.IvalidacaoTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private List<IvalidacaoTopico> validacoes;


    public DadosRetornoCadastroTopico cadastrarTopico(DadosCadastroTopico dados){
        validacoes.forEach(v -> v.validar(dados));

        var cursoDoTopico = cursoService.buscarCursoPorId(dados.idCurso());
        var usuarioDoTopico = usuarioService.buscarUsuarioPorId(dados.idUsuario());
        var novoTopico = new Topico(dados, usuarioDoTopico, cursoDoTopico);
        repository.save(novoTopico);

        return new DadosRetornoCadastroTopico(novoTopico);
    }

    public Topico buscarTopicoPorId(Long id){
        return repository.getReferenceById(id);
    }


}
