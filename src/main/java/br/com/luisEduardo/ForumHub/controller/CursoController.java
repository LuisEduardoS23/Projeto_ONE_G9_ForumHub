package br.com.luisEduardo.ForumHub.controller;

import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosCadastroCurso;
import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosDetalhamentoCurso;
import br.com.luisEduardo.ForumHub.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroCurso cursoDto, UriComponentsBuilder uriComponentsBuilder) {
        var dadosResposta = service.cadastrarCurso(cursoDto);
        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(dadosResposta.id()).toUri();
        return ResponseEntity.created(uri).body(dadosResposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCurso> buscarPorId (@PathVariable Long id) {
        var dadosDetalhamento = service.detalharCursoPeloId(id);
        return ResponseEntity.ok(dadosDetalhamento);
    }



}
