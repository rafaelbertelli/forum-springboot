package br.com.rafael.forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.rafael.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

  List<Topico> findByCursoNome(String nomeCurso);

  @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
  List<Topico> encontrarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
