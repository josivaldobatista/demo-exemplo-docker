package com.example.demo.cadastrocategoria;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.demo.cadastroproduto.Produto;

public class CategoriaRequest {

  @NotBlank
  private String nome;

  private List<Produto> produtos = new ArrayList<>();

  @Deprecated
  public CategoriaRequest() {
  }

  public CategoriaRequest(String nome, List<Produto> produtos) {
    this.nome = nome;
    this.produtos = produtos;
  }

  public Categoria toModel() {
    return new Categoria(nome);
  }

  public String getNome() {
    return nome;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

}
