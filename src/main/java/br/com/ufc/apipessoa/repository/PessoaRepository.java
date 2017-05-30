package br.com.ufc.apipessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.apipessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa , Integer>{

}
