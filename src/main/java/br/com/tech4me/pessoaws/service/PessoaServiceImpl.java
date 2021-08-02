package br.com.tech4me.pessoaws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.pessoaws.model.Pessoa;
import br.com.tech4me.pessoaws.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository repositorio;

    @Override
    public List<Pessoa> obterTodos() {
        return repositorio.findAll();
    }

    @Override
    public Pessoa obterPessoaPorId(String id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    @Override
    public void excluirPessoaPorId(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public Pessoa atualizarPessoaPorId(String id, Pessoa pessoa) {
        pessoa.setId(id);
        return repositorio.save(pessoa);
    }
    
}
