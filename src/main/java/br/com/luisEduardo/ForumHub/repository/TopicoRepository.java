package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer> {
}
