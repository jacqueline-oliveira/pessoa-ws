package br.com.tech4me.pessoaws.service;

import java.util.List;

import br.com.tech4me.pessoaws.model.Pessoa;

public interface PessoaService {

    List<Pessoa> obterTodos();
    Pessoa obterPessoaPorId(String id);
    Pessoa cadastrarPessoa(Pessoa pessoa);
    void excluirPessoaPorId(String id);
    Pessoa atualizarPessoaPorId(String id, Pessoa pessoa);
    
}
