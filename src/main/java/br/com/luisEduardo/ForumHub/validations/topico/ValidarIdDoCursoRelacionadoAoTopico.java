package br.com.luisEduardo.ForumHub.validations.topico;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarIdDoCursoRelacionadoAoTopico implements IvalidacaoTopico{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(DadosCadastroTopico dados) {
        var cursoComIdPassado = cursoRepository.findCursoById(dados.idCurso());
        System.out.println(cursoComIdPassado);

        if(cursoComIdPassado.isEmpty()){
            throw new ValidacaoException("Curso com o ID passado não existe!");
        }
    }
}
