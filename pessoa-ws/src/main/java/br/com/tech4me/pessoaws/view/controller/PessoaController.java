package br.com.tech4me.pessoaws.view.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import br.com.tech4me.pessoaws.view.model.PessoaRequest;
import java.util.Optional;
import javax.validation.Valid;

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

    @GetMapping(value = "/porta")
    public String verificarPorta(@Value("${local.server.port}") String porta) {
        return String.format("Microsserviço respondeu a partir da porta %s", porta);
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
    public ResponseEntity<PessoaDto> cadastrarPessoa(@RequestBody @Valid PessoaDto pessoa) { 
        return new ResponseEntity<>(servico.cadastrarPessoa(pessoa), HttpStatus.CREATED); 
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable String id) {
        servico.excluirPessoaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable String id, @RequestBody @Valid PessoaRequest pessoa) {
        PessoaDto dto = new ModelMapper().map(pessoa, PessoaDto.class);
        Optional<PessoaDto> pess = servico.atualizarPessoaPorId(id, dto);

        if (pess.isPresent()) {
            return new ResponseEntity<>(pess.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        
    }

    /*
    Os exemplos abaixo são para demonstrar o uso de classes específicas para os 
    dados de Request e Response. O uso desses modelos ajudam a proteger os dados da 
    aplicação, utilizando apenas os atributos que de fato precisam ser demonstrados.
    
    Utilizamos o ModelMapper junto com o DTO (Data Transfer Object) para transferir 
    os dados entre as classes. 
    
    @GetMapping
    public ResponseEntity<List<PessoaResponse>> obterPessoas() {
        List<PessoaDto> dto = servico.obterTodos();

        List<PessoaResponse> response = dto.stream()
           .map(d -> new ModelMapper().map(d, PessoaResponse.class))
           .collect(Collectors.toList());

      return new ResponseEntity<>(response, HttpStatus.ACCEPTED);  
    }

    @PostMapping
    public ResponseEntity<PessoaResponseComObservacao> cadastrarPessoa(@RequestBody PessoaRequestComObservacao pessoa) {
        ModelMapper mapper = new ModelMapper();
        PessoaDto dto = mapper.map(pessoa, PessoaDto.class);
        dto = servico.cadastrarPessoa(dto);
        PessoaResponseComObservacao pessoaResponse = mapper.map(dto, PessoaResponseComObservacao.class);
        
        return new ResponseEntity<>(pessoaResponse, HttpStatus.CREATED); 
    } */
    
}
