package com.colini.models;

public class Aluno {
    private String nome;
    private String nascimento;
    private Integer cpf;
    private String email;

    public Aluno(String nome, String nascimento, Integer cpf, String email) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

// Classe Aluno: nome, nascimento, cpf, email