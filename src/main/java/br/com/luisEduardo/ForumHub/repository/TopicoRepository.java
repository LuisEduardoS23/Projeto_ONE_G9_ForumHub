package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findTopicosByTituloAndStatusTrue(String titulo);

    Optional<Topico> findTopicosByIdAndStatusTrue(Long aLong);
}
