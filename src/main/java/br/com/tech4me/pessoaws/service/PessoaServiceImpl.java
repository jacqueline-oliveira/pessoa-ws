package br.com.tech4me.pessoaws.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.pessoaws.model.Pessoa;
import br.com.tech4me.pessoaws.repository.PessoaRepository;
import br.com.tech4me.pessoaws.shared.PessoaDto;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository repositorio;

    @Override
    public List<PessoaDto> obterTodos() {
        List<Pessoa> pess = repositorio.findAll();

        return pess.stream()
            .map(p -> new ModelMapper().map(p, PessoaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<PessoaDto> obterPessoaPorId(String id) {
        Optional<Pessoa> pess = repositorio.findById(id);

        if (pess.isPresent()) {
            return Optional.of(new ModelMapper().map(pess.get(), PessoaDto.class));
        }
        return Optional.empty();
    }

    @Override
    public PessoaDto cadastrarPessoa(PessoaDto pessoa) {
        ModelMapper mapper = new ModelMapper();
        Pessoa pessParaSalvar = mapper.map(pessoa, Pessoa.class); 
        pessParaSalvar = repositorio.save(pessParaSalvar);
        return mapper.map(pessParaSalvar, PessoaDto.class);  
    }

    @Override
    public void excluirPessoaPorId(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public Optional<PessoaDto> atualizarPessoaPorId(String id, PessoaDto pessoa) {
        ModelMapper mapper = new ModelMapper();
        Optional<Pessoa> pess = repositorio.findById(id);
        Pessoa pessParaSalvar = mapper.map(pessoa, Pessoa.class);

        if (pess.isPresent()) {
            pessParaSalvar.setId(id);
            pessParaSalvar = repositorio.save(pessParaSalvar);
            return Optional.of(mapper.map(pessParaSalvar, PessoaDto.class));
        }
        
        return Optional.empty();
        
    }
    
}
