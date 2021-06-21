package com.example.demo.cadastroproduto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.cadastrocategoria.Categoria;
import com.example.demo.cadastrocategoria.CategoriaResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResponse {

  @JsonProperty
  private String nome;

  @JsonProperty
  private String descricao;

  @JsonProperty
  private String marca;

  @JsonProperty
  private List<CategoriaResponse> categorias = new ArrayList<>();

  public ProdutoResponse(Produto entity) {
    nome = entity.getNome();
    descricao = entity.getDescricao();
    marca = entity.getMarca();
  }

  public ProdutoResponse(Produto entity, List<Categoria> categorias) {
    this(entity);
    categorias.forEach(cat -> this.categorias.add(new CategoriaResponse(cat)));
  }

}
