package com.example.demo.cadastrocategoria;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.cadastroproduto.Produto;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String uuid = UUID.randomUUID().toString();

  @NotBlank
  private String nome;

  @ManyToMany(mappedBy = "categorias")
  private List<Produto> produtos = new ArrayList<>();

  @Deprecated
  public Categoria() {
  }

  public Categoria(String nome) {
    this.nome = nome;
  }
  
  public Long getId() {
    return id;
  }

  public String getUuid() {
    return uuid;
  }

  public String getNome() {
    return nome;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

}
