package br.com.luisEduardo.ForumHub.controller;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import br.com.luisEduardo.ForumHub.dto.usuarioDTOS.DadosRetornoCadastroUsuario;
import br.com.luisEduardo.ForumHub.model.Topico;
import br.com.luisEduardo.ForumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController{

    @Autowired
    private TopicoService service;

    @PostMapping()
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico topicoDto, UriComponentsBuilder uriBuilder){
        var dadosRetorno = service.cadastrarTopico(topicoDto);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dadosRetorno.id()).toUri();
        return ResponseEntity.created(uri).body(dadosRetorno);
    }

}
