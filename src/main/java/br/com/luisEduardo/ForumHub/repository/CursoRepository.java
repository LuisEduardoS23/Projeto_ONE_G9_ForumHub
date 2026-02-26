package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {


    List<Curso> nome(String nome);

    Optional<Curso> getReferenceByNome(String nomeCurso);
}
