package br.com.alura.forumHub.service;

import br.com.alura.forumHub.domain.DTO.cadastro.Cadastro;
import br.com.alura.forumHub.domain.DTO.usuario.UpdateUsuario;
import br.com.alura.forumHub.domain.DTO.usuario.Usuario;

import java.awt.print.Pageable;
import java.util.List;

public class UsuarioService {
    public Object cadastrarNovoUsuario(Cadastro dados) {
        return dados;
    }

    public void delete(long id) {
        System.out.println("Usuário deletado");
    }

    public Object update(UpdateUsuario usuario) {
        return usuario;
    }

    public List<Usuario> list(Pageable id) {
        return List.of();
    }

    public Object detail(Long id) {
        return id;
    }
}
