package br.com.rafael.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafael.forum.modelo.Curso;
import br.com.rafael.forum.modelo.Topico;

@RestController
public class TopicosController {
  
  @RequestMapping("/topicos")
  public List<Topico> lista() {
    
    Topico topico = new Topico("Dúvida!", "Dúvida com spring boot", new Curso("Spring", "programação"));

    return Arrays.asList(topico,topico,topico);

  }

}
