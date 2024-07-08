package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.domain.DTO.usuario.UpdateUsuario;
import br.com.alura.forumHub.domain.DTO.usuario.Usuario;
import br.com.alura.forumHub.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable(value="id") Long id) {
        usuarioService.delete(id.longValue());
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateUsuario usuario) {
        var updatedUser = usuarioService.update(usuario);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> list(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return ResponseEntity.ok(usuarioService.list(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable(value="id") Long id) {
        return ResponseEntity.ok(usuarioService.detail(id));
    }
}
