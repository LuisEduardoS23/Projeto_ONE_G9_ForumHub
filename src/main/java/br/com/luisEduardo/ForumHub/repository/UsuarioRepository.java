package br.com.luisEduardo.ForumHub.repository;

import br.com.luisEduardo.ForumHub.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String emailUsuario);

    Optional<Usuario> findByNome(@NotBlank(message = "O nome do usuário não deve ser nulo ou em branco!") String nome);


    Optional<Usuario> getReferenceByEmail(@NotBlank(message = "O e-mail do usuário não deve ser nulo ou em branco!") @Email(message = "Formato de e-mail inválido!") String email);

    Optional<Usuario> findUsuarioById(Long id);
}
