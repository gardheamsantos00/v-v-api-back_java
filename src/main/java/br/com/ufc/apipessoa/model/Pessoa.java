package br.com.ufc.apipessoa.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.ufc.apipessoa.model.Pessoa.Funcao;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Funcao funcao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	
	public enum Funcao{
		ATOR("Ator"), DIRETOR("Diretor");
		
		private String descricao;
		private Funcao(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return this.descricao;
		}
		
	}
}
