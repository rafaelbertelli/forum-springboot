package br.com.rafael.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.rafael.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

  Curso findByNome(String nome);

}
