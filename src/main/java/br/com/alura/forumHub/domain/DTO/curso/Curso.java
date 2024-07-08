package br.com.alura.forumHub.domain.DTO.curso;

public record Curso(Long id,
                    String nome,
                    String categoria,
                    Boolean ativo) { }
