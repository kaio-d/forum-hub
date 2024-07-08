package br.com.alura.forumHub.repository;

import br.com.alura.forumHub.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    List<Usuario> findAllByAtivoTrue(Usuario user);

    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.perfil.id = 1")
    Long countAdministrators();
}
