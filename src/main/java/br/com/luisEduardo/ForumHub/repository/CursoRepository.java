package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Optional<Curso> getReferenceByNome(String nomeCurso);

    Optional<Curso> findCursoByIdAndAtivoTrue(Long id);
}
