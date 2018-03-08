package br.com.automacao.industrial.repository.pessoafisica;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automacao.industrial.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>, PessoaFisicaRepositoryQuery {

}
