package br.com.alura.forumHub.repository;

import br.com.alura.forumHub.domain.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findAllByAtivoTrue(Pageable pageable);
}
