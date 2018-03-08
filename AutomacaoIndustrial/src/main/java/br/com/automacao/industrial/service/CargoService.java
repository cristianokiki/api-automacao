package br.com.automacao.industrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.industrial.model.Cargo;
import br.com.automacao.industrial.repository.CargoRepository;

@Service
@Transactional(readOnly = true)
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public List<Cargo> buscarTodosCargos() {
		return this.cargoRepository.findAll();
	}

	public Cargo novo(Cargo cargo) {
		return this.cargoRepository.save(cargo);
	}

}
