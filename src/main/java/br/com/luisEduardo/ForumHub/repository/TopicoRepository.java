package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Topico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findTopicosByTitulo(@NotBlank(message = "O título do tópico não deve ser nulo ou estar em branco!") String titulo);
}
