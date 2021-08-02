package br.com.tech4me.pessoaws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.pessoaws.model.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {
    
}
