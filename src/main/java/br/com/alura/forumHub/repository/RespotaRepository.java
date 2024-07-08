package br.com.alura.forumHub.repository;

import br.com.alura.forumHub.domain.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespotaRepository extends JpaRepository<Resposta, Long> {
}
