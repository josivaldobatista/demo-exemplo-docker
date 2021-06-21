package com.example.demo.cadastroproduto;

import javax.validation.constraints.NotBlank;

public class ProdutoRequest {

  @NotBlank
  private String nome;

  @NotBlank
  private String descricao;

  @NotBlank
  private String marca;

  public ProdutoRequest(String nome, String descricao, String marca) {
    this.nome = nome;
    this.descricao = descricao;
    this.marca = marca;
  }

  public Produto toModel() {
    return new Produto(nome, descricao, marca);
  }

}
