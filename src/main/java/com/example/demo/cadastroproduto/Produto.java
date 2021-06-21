package com.example.demo.cadastroproduto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.cadastrocategoria.Categoria;

@Entity
@Table(name = "tb_produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String uuid = UUID.randomUUID().toString();

  @NotBlank
  private String nome;

  @NotBlank
  private String descricao;

  @NotBlank
  private String marca;

  @ManyToMany
  @JoinTable(
    name = "tb_produto_categoria",
    joinColumns = @JoinColumn(name = "idProduto"),
    inverseJoinColumns = @JoinColumn(name = "idCategoria"))
  private List<Categoria> categorias = new ArrayList<>();

  @Deprecated
  public Produto() {
  }

  public Produto(String nome, String descricao, String marca) {
    this.nome = nome;
    this.descricao = descricao;
    this.marca = marca;
  }
  
  public String getUuid() {
    return uuid;
  }

  public String getNome() {
    return this.nome;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public String getMarca() {
    return this.marca;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

}
