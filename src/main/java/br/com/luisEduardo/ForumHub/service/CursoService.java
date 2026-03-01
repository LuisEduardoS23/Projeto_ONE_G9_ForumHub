package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosCadastroCurso;
import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosDetalhamentoCurso;
import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosRetornoCadastroCurso;
import br.com.luisEduardo.ForumHub.model.Curso;
import br.com.luisEduardo.ForumHub.repository.CursoRepository;
import br.com.luisEduardo.ForumHub.validations.curso.IValidacaoCurso;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    List<IValidacaoCurso> validacaoCurso;


    public DadosRetornoCadastroCurso cadastrarCurso (DadosCadastroCurso dados){
        validacaoCurso.forEach(v -> v.validar(dados));
        Curso curso = new Curso(dados);
        cursoRepository.save(curso);
        return new DadosRetornoCadastroCurso(curso);
    }


    public DadosDetalhamentoCurso detalharCursoPeloId(Long id) {
        var curso = cursoRepository.findCursoById(id);
        if (curso.isEmpty()){
            throw new EntityNotFoundException();
        }
        return new DadosDetalhamentoCurso(curso.get());
    }
}
