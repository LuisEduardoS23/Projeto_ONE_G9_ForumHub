package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
