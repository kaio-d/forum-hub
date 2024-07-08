package br.com.alura.forumHub.domain.DTO.usuario;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record UpdateUsuario(@NotNull Long id,
                            String nome,
                            String email,
                            String senha,
                            @JsonAlias("perfil_id") Long perfilId,
                            Boolean ativo) {
    public UpdateUsuario withEncryptedPassword(String password) {
        return new UpdateUsuario(id, nome, email, password, perfilId, ativo);
        }
    }
