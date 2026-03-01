package br.com.luisEduardo.ForumHub.controller;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosDetalhamentoTopico;
import br.com.luisEduardo.ForumHub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar (@PathVariable Long id){
        var detalhesTopico = service.detalharTopicoPeloId(id);
        return ResponseEntity.ok(detalhesTopico);
    }

}
