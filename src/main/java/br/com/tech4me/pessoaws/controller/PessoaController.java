package br.com.tech4me.pessoaws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.pessoaws.model.Pessoa;
import br.com.tech4me.pessoaws.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    PessoaService servico;

    @GetMapping
    public List<Pessoa> obterPessoas() {
      return servico.obterTodos();  
    }

    @GetMapping(value = "/{id}")
    public Pessoa obterPessoaPorId(@PathVariable String id) {
        return servico.obterPessoaPorId(id);
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return servico.cadastrarPessoa(pessoa);
    }

    @DeleteMapping(value = "/{id}")
    public void excluirPessoa(@PathVariable String id) {
        servico.excluirPessoaPorId(id);
    }

    @PutMapping(value = "/{id}")
    public Pessoa atualizarPessoa(@PathVariable String id, @RequestBody Pessoa pessoa) {
        return servico.atualizarPessoaPorId(id, pessoa);
    }
    
}
