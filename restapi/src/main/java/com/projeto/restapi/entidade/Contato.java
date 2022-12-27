package com.projeto.restapi.entidade;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(nullable = false)
   private String nome;
   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private String endereco;
   @Column(nullable = true)
   private String endereco2;
   
   public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getEndereco() {
    return endereco;
}
public void setEndereco(String endereco) {
    this.endereco = endereco;
}
public String getEndereco2() {
    return endereco2;
}
public void setEndereco2(String endereco2) {
    this.endereco2 = endereco2;
}
   
    
}
