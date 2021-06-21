package com.example.demo.cadastroproduto;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.cadastrocategoria.Categoria;
import com.example.demo.cadastrocategoria.CategoriaRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController {

  private ProdutoRepository produtoRepository;

  private CategoriaRepository categoriaRepository;

  public ProdutoController(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
    this.produtoRepository = produtoRepository;
    this.categoriaRepository = categoriaRepository;
  }

  @PostMapping
  private ResponseEntity<?> salvarProduto(@Valid @RequestBody ProdutoRequest request) {
    Produto entity = request.toModel();
    entity = produtoRepository.save(entity);
    List<Categoria> categorias = categoriaRepository.findAll();

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(entity.getUuid()).toUri();

    return ResponseEntity.created(uri).body(new ProdutoResponse(entity, categorias));
  }
}
