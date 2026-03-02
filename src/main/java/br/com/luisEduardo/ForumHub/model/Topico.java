package br.com.luisEduardo.ForumHub.model;

import br.com.luisEduardo.ForumHub.dto.topicoDTOS.DadosCadastroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private boolean status;

    //RELACIONAMENTOS

    @OneToMany (mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resposta> respostas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;


    public Topico(DadosCadastroTopico dados, Usuario usuarioDoTopico, Curso cursoDoTopico) {
        this.id = null;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.usuario = usuarioDoTopico;
        this.curso = cursoDoTopico;
        this.status = true;
    }

    public void excluir() {
        this.status = false;
    }
}
