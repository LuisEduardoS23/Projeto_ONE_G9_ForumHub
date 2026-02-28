package br.com.luisEduardo.ForumHub.controller;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosCadastroResposta;
import br.com.luisEduardo.ForumHub.service.RespostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @PostMapping
    public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroResposta respostaDto, UriComponentsBuilder uriBuilder) {
        var dadosResposta = service.cadastrarResposta(respostaDto);
        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(dadosResposta.id()).toUri();
        return ResponseEntity.created(uri).body(dadosResposta);
    }
}
