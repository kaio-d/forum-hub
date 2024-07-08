package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.domain.DTO.cadastro.Cadastro;
import br.com.alura.forumHub.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarCadastro(@RequestBody @Valid Cadastro dados, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = usuarioService.cadastrarNovoUsuario(dados);
        var uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getClass()).toUri();

        return ResponseEntity.created(uri).body(usuario);

    }

}
