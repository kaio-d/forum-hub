package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.domain.DTO.usuario.Usuario;
import br.com.alura.forumHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid Usuario dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());
            return ResponseEntity.ok(new TokenService(tokenJwt));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
