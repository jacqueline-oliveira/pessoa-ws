package br.com.tech4me.pessoaws.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.pessoaws.service.PessoaService;
import br.com.tech4me.pessoaws.shared.PessoaDto;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin
public class PessoaController {
    @Autowired
    PessoaService servico;

    @GetMapping
    public ResponseEntity<List<PessoaDto>> obterPessoas() {
      return new ResponseEntity<>(servico.obterTodos(), HttpStatus.ACCEPTED);  
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> obterPessoaPorId(@PathVariable String id) {
        Optional<PessoaDto> pess = servico.obterPessoaPorId(id);

        if (pess.isPresent()) {
            return new ResponseEntity<>(pess.get(), HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       
    }

    @PostMapping
    public ResponseEntity<PessoaDto> cadastrarPessoa(@RequestBody PessoaDto pessoa) {
        return new ResponseEntity<>(servico.cadastrarPessoa(pessoa), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable String id) {
        servico.excluirPessoaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable String id, @RequestBody PessoaDto pessoa) {
        Optional<PessoaDto> pess = servico.atualizarPessoaPorId(id, pessoa);

        if (pess.isPresent()) {
            return new ResponseEntity<>(pess.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
    }
    
}
