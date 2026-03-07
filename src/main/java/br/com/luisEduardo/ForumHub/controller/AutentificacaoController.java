package br.com.luisEduardo.ForumHub.controller;

import br.com.luisEduardo.ForumHub.dto.tokenDTOS.DadosTokenJWT;
import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosAutentificacaoUsuario;
import br.com.luisEduardo.ForumHub.model.Usuario;
import br.com.luisEduardo.ForumHub.service.TokenService;
import br.com.luisEduardo.ForumHub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutentificacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutentificacaoUsuario dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var autentificacao = authenticationManager.authenticate(token);
        var usuario = (Usuario) autentificacao.getPrincipal();
        usuarioService.reativarContaCasoEstejaDesativada(usuario);
        var tokenAutenticado = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(tokenAutenticado));
    }//////////////////////////////////////////////////////////

}
