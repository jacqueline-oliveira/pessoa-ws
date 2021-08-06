package br.com.tech4me.pessoaws.view.model;

public class PessoaResponse {
    private String id;
    private String nome;
    private String sobrenome;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return String.format("%s %s", this.nome, this.sobrenome);
    }


    
}
