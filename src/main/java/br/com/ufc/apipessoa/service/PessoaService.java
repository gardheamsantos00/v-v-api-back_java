package br.com.ufc.apipessoa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.apipessoa.model.Pessoa;
import br.com.ufc.apipessoa.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	
	
	public Pessoa cadastar(Pessoa pessoa){
		
		return 	pessoaRepository.save(pessoa);
		
	}
	
	public Collection<Pessoa> buscarTodos(){
		return pessoaRepository.findAll();
	}
	
	
	public void excluir(Pessoa pessoa){
		pessoaRepository.delete(pessoa);
	}
	
	public Pessoa buscarPorID(Integer id){
		return pessoaRepository.findOne(id);
	}
	
	
	public Pessoa alterar(Pessoa pessoa){
		 pessoaRepository.save(pessoa);
		 return pessoa;
	}
}
