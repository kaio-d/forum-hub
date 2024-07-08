package br.com.alura.forumHub.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name="Resposta")
@Table(name="respostas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario autor;
    private boolean solucao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="topico_id")
    private Topico topico;

}
