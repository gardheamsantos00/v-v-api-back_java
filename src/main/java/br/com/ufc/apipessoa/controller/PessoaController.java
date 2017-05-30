package br.com.ufc.apipessoa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.apipessoa.model.Pessoa;
import br.com.ufc.apipessoa.service.PessoaService;

@Controller
@CrossOrigin(origins = "*")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	
	//Requisições ---------------------------------------------------
	@RequestMapping(value="/home")
	public String home(){
		return "index";
	}
	

	@RequestMapping(value="/cadastrarPessoa" , 
			method = RequestMethod.POST, 
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> cadastrarClinte(@RequestBody Pessoa pessoa){
	  Pessoa pessoaSalva = pessoaService.cadastar(pessoa);
	  
	  return new ResponseEntity<>(pessoaSalva , HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/buscaPessoa", 
			method=RequestMethod.GET , 
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pessoa>> buscaTodos(){
		
		Collection<Pessoa> pessoaBuscadas = pessoaService.buscarTodos();
		
		return new ResponseEntity<>(pessoaBuscadas, HttpStatus.OK);
	}
	

	@RequestMapping(value="/removerPessoa/{id}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<Collection<Pessoa>> removerPessoa(@PathVariable Integer id){
		
		Pessoa pessoaEncontrada = pessoaService.buscarPorID(id);
		if(pessoaEncontrada == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		pessoaService.excluir(pessoaEncontrada);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@RequestMapping(value = "/recuperaPessoa/{id}", method = RequestMethod.GET, 
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> recuperaPessoa(@PathVariable Integer id) {
		Pessoa pessoa = pessoaService.buscarPorID(id);
		
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/alterarPessoa", 
			method=RequestMethod.PUT,
			consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> alterarPessoa(@RequestBody Pessoa pessoa){
		
		Pessoa pessoaAlterada = pessoaService.alterar(pessoa);
		
		return new ResponseEntity<>(pessoaAlterada, HttpStatus.OK);
	}
}
