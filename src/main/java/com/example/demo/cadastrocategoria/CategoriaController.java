package com.example.demo.cadastrocategoria;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController {

  private CategoriaRepository repository;

  public CategoriaController(CategoriaRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public ResponseEntity<?> salvarCategoria(@Valid @RequestBody CategoriaRequest request) {
    Categoria entity = request.toModel();
    entity = repository.save(entity);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(entity.getUuid()).toUri();

    return ResponseEntity.created(uri).body(new CategoriaResponse(entity));
  }
  
}
