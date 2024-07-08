package br.com.alura.forumHub.domain.DTO.cadastro;

import jakarta.validation.constraints.NotNull;

public record Cadastro(@NotNull String nome,
                       @NotNull String email,
                       @NotNull String senha) {
}
