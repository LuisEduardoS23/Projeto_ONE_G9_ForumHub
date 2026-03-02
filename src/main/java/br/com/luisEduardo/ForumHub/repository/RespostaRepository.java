package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    Optional<Resposta> findRespostasByIdAndAtivoTrue(Long id);
}
