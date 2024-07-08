package br.com.alura.forumHub.repository;

import br.com.alura.forumHub.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findAllByAtivoTrue(Topico topico);
}
