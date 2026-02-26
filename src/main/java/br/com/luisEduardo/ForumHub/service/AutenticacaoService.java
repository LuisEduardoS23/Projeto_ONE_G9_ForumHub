package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String emailUsuario) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(emailUsuario);
    }
}
