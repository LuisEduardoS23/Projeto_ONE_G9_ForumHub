package br.com.luisEduardo.ForumHub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity
@Table(name = "respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String mensagem;
    LocalDateTime dataCriacao;
    String solucao;

    //RELACIONAMENTOS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    Topico topico;

}
