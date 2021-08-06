package br.com.tech4me.pessoaws.view.model;

import javax.validation.constraints.NotEmpty;

public class PessoaRequest {
    @NotEmpty(message = "O nome deve ser preenchido")
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    
    
}
