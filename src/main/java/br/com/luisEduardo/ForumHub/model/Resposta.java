package br.com.luisEduardo.ForumHub.model;

import br.com.luisEduardo.ForumHub.dto.respostaDTOS.DadosCadastroResposta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity
@Table(name = "respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDate datacriacao;
    private String solucao;

    //RELACIONAMENTOS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Resposta(DadosCadastroResposta dados, Topico topicoDaResposta, Usuario usuarioDaResposta) {
        this.id = null;
        this.mensagem = dados.mensagem();
        this.solucao = dados.solucao();
        this.datacriacao = LocalDate.now();
        this.topico = topicoDaResposta;
        this.usuario = usuarioDaResposta;
    }
}
