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

    Optional<Usuario> findByNome(String nome);


    Optional<Usuario> getReferenceByEmail( String email);

    Optional<Usuario> findUsuarioByIdAndAtivoTrue(Long id);
}
