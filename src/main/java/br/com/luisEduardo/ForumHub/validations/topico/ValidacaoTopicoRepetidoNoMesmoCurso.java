package br.com.luisEduardo.ForumHub.validations.topico;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.CursoRepository;
import br.com.luisEduardo.ForumHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTopicoRepetidoNoMesmoCurso implements IvalidacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosCadastroTopico dados) {
        var topicoComMesmoTitulo = topicoRepository.findTopicosByTitulo(dados.titulo());

        if (topicoComMesmoTitulo.isPresent()) {
            throw new ValidacaoException("Tópico com mesmo título já cadastrado no curso, por favor evite comentar sobre assuntos já discutidos!");
        }
    }
}
