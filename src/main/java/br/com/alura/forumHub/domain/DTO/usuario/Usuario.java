package br.com.alura.forumHub.domain.DTO.usuario;

public record Usuario(Long id,
                      String email,
                      String nome,
                      String perfil,
                      String senha,
                      Boolean ativo) {
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
