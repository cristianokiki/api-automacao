package br.com.automacao.industrial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automacao.industrial.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
