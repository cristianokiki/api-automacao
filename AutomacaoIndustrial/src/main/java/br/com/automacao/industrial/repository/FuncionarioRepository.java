package br.com.automacao.industrial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automacao.industrial.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}