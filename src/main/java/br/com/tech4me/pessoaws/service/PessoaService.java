package br.com.tech4me.pessoaws.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.pessoaws.shared.PessoaDto;

public interface PessoaService {

    List<PessoaDto> obterTodos();
    Optional<PessoaDto> obterPessoaPorId(String id);
    PessoaDto cadastrarPessoa(PessoaDto pessoa);
    void excluirPessoaPorId(String id);
    Optional<PessoaDto> atualizarPessoaPorId(String id, PessoaDto pessoa);
    
}
