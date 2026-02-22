package br.com.luisEduardo.ForumHub.model;

import br.com.luisEduardo.ForumHub.dto.cursoDTOS.DadosCadastroCurso;
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
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String categoria;

    //RELACIONAMENTOS

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Topico> topicos;

    public Curso(DadosCadastroCurso dados) {
        this.id = null;
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }
}
