package br.com.alura.forumHub.service;

import br.com.alura.forumHub.domain.DTO.curso.Curso;
import br.com.alura.forumHub.domain.DTO.curso.UpdateDataCurso;
import br.com.alura.forumHub.domain.model.Usuario;
import br.com.alura.forumHub.infra.exception.ResourceNotFoundException;
import br.com.alura.forumHub.repository.CursoRepository;
import br.com.alura.forumHub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Curso create(@Valid Curso curso) {
        isAdmin();

        Curso newCurso = new Curso(null, curso.nome(), curso.categoria(), true);
        return newCurso;
    }

    private void isAdmin() {
        Usuario usuarioLogado = usuarioRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        if (!usuarioLogado.getPerfil().getNome().equals("ADMIN")) {
            throw new RuntimeException("Acesso negado!");
        }
    }

    public void delete(Long id) {
        isAdmin();

        br.com.alura.forumHub.domain.model.Curso curso = cursoRepository.getReferenceById(id);
        curso.delete();
    }


    public Curso update(UpdateDataCurso curso) {
        isAdmin();

        br.com.alura.forumHub.domain.model.Curso updateCurso = cursoRepository.findById(curso.id())
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + curso.id()));

        updateCurso.update(curso);
        cursoRepository.save(updateCurso);

        return new Curso(updateCurso.id(), updateCurso.getNome(), updateCurso.getCategoria(), updateCurso.getAtivo());
    }


    public List<br.com.alura.forumHub.domain.model.Curso> list(Pageable paginacao) {
        Page<br.com.alura.forumHub.domain.model.Curso> page = cursoRepository.findAllByAtivoTrue(paginacao);
        return page.getContent();
    }

    public br.com.alura.forumHub.domain.model.Curso detail(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + id));
    }

}
