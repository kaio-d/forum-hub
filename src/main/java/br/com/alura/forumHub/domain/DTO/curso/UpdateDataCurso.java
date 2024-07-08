package br.com.alura.forumHub.domain.DTO.curso;

import jakarta.validation.constraints.NotNull;

public record UpdateDataCurso(@NotNull Long id,
                              String nome,
                              String categoria,
                              Boolean ativo) {
}
