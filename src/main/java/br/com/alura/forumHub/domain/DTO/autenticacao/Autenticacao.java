package br.com.alura.forumHub.domain.DTO.autenticacao;

import jakarta.validation.constraints.NotNull;

public record Autenticacao(@NotNull String email,
                           @NotNull String senha) {
}
