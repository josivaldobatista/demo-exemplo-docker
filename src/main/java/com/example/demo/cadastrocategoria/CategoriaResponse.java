package com.example.demo.cadastrocategoria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriaResponse {

  @JsonProperty
  private String nome;

  public CategoriaResponse(Categoria entity) {
    nome = entity.getNome();
  }

}
