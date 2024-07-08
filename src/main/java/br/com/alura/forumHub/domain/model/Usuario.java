package br.com.alura.forumHub.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="perfil_id")
    private Perfil perfil;
    private Boolean ativo;

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                ", ativo=" + ativo +
                '}';
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}
