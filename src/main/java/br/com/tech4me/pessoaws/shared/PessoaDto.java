package br.com.tech4me.pessoaws.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PessoaDto {
    private String id;
    @NotEmpty(message = "O nome deve ser preenchido")
    @NotBlank(message = "Nome não pode ter apenas espaços em branco")
    @Size(min =3, message = "Nome tem que ter pelo menos 3 caracteres")
    private String nome;
    @NotEmpty(message = "O sobrenome deve ser preenchido")
    @NotBlank(message = "Sobrenome não pode ter apenas espaços em branco")
    private String sobrenome;
    @Positive(message = "Idade deve ser maior que zero")
    private int idade;
    private String observacoes;
    
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    
    
}
