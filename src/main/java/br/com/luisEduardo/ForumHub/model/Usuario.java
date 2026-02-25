package br.com.luisEduardo.ForumHub.model;

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
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    //RELACIONAMENTOS

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Topico> topicos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Resposta> respostas;



}
