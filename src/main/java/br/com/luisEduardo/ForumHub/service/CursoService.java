package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosCadastroCurso;
import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosRetornoCurso;
import br.com.luisEduardo.ForumHub.model.Curso;
import br.com.luisEduardo.ForumHub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;


    public DadosRetornoCurso cadastrarCurso (DadosCadastroCurso dados){
        Curso curso = new Curso(dados);
        cursoRepository.save(curso);
        return new DadosRetornoCurso(curso);
    }

}
