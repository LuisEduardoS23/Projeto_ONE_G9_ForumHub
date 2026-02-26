package br.com.luisEduardo.ForumHub.controller;

import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosCadastroUsuario;
import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosRetornoCadastroUsuario;
import br.com.luisEduardo.ForumHub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<DadosRetornoCadastroUsuario> cadastrar (@RequestBody @Valid DadosCadastroUsuario usuarioDto, UriComponentsBuilder uriBuilder) {
        var dadosResposta = usuarioService.cadastrarNovoUsuario(usuarioDto);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(dadosResposta.id()).toUri();
        return ResponseEntity.created(uri).body(dadosResposta);
    }

}
