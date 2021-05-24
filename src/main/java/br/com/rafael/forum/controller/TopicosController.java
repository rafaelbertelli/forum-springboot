package br.com.rafael.forum.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.rafael.forum.controller.dto.TopicoDTO;
import br.com.rafael.forum.controller.form.TopicoForm;
import br.com.rafael.forum.modelo.Topico;
import br.com.rafael.forum.repository.CursoRepository;
import br.com.rafael.forum.repository.TopicoRepository;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

  @Autowired
  private TopicoRepository topicoRepository;
  @Autowired
  private CursoRepository cursoRepository;


  @GetMapping
  public List<TopicoDTO> lista(String nomeCurso) {

    if (nomeCurso == null) {
      List<Topico> topicos = topicoRepository.findAll();
      return TopicoDTO.converter(topicos);
    }

    List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
    return TopicoDTO.converter(topicos);
  }

  @PostMapping
  public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form,
      UriComponentsBuilder uriBuilder) {

    Topico topico = form.converter(cursoRepository);

    topicoRepository.save(topico);

    URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(uri).body(new TopicoDTO(topico));
  }
}
