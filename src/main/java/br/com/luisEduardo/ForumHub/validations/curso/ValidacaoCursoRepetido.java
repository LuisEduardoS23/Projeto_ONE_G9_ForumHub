package br.com.luisEduardo.ForumHub.validations.curso;

import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosCadastroCurso;
import br.com.luisEduardo.ForumHub.exceptions.ValidacaoException;
import br.com.luisEduardo.ForumHub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoCursoRepetido implements IValidacaoCurso {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(DadosCadastroCurso dados){
        var nomeCurso = dados.nome();
        var cursoComMesmoNome = cursoRepository.getReferenceByNome(nomeCurso);
        if (cursoComMesmoNome.isPresent()){
            throw new ValidacaoException("Curso com mesmo nome '"+dados.nome()+ "' já cadastrado no sistema!");
        }
    }
}
