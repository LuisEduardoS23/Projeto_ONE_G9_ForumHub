package br.com.luisEduardo.ForumHub.service;

import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosCadastroUsuario;
import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosDetalhamentoUsuario;
import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosRetornoCadastroUsuario;
import br.com.luisEduardo.ForumHub.model.Usuario;
import br.com.luisEduardo.ForumHub.repository.UsuarioRepository;
import br.com.luisEduardo.ForumHub.validations.usuario.IValidacaoUsuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private List<IValidacaoUsuario> validacoes;


    public DadosRetornoCadastroUsuario cadastrarNovoUsuario(DadosCadastroUsuario dados){
        validacoes.forEach(v -> v.validar(dados));

        var senhaCriptografada = criptografarSenha(dados.senha());
        System.out.println(senhaCriptografada);
        var usuario = new Usuario(dados.nome(), dados.email(), senhaCriptografada);
        repository.save(usuario);
        return new DadosRetornoCadastroUsuario(usuario);
    }

    public String criptografarSenha(String senha){
        return passwordEncoder.encode(senha);
    }

    public DadosDetalhamentoUsuario detalharUsuarioPeloId(Long id) {
        var usuario = repository.findUsuarioById(id);
        if(usuario.isEmpty()){
            throw new EntityNotFoundException();
        }

        return new DadosDetalhamentoUsuario(usuario.get());
    }
}
