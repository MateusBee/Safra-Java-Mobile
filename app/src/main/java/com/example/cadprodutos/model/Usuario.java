package com.example.cadprodutos.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String confirm_senha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirm_senha() {
        return confirm_senha;
    }

    public void setConfirm_senha(String confirm_senha) {
        this.confirm_senha = confirm_senha;
    }
}
