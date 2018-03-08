package br.com.automacao.industrial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automacao.industrial.model.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

}
