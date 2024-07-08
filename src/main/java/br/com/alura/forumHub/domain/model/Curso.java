package br.com.alura.forumHub.domain.model;

import br.com.alura.forumHub.domain.DTO.curso.UpdateDataCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String categoria;
    private Boolean ativo;

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoria='" + categoria + '\'' +
                ", ativo=" + ativo +
                '}';
    }

    public void delete() {
        System.out.println("Curso deletado!");
    }

    public void update(UpdateDataCurso updateData) {
        this.name = updateData.nome();
        this.categoria = updateData.categoria();
        this.ativo = updateData.ativo();
    }

    public Long id() {
        return null;
    }

    public String getNome() {
        return name;
    }

    public String getCategoria() {
        return categoria;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
