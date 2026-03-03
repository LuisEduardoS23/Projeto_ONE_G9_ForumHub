package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutentificacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String emailUsuario) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(emailUsuario);
    }
}
