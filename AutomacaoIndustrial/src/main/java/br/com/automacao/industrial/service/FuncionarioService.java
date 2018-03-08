package br.com.automacao.industrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.industrial.model.Funcionario;
import br.com.automacao.industrial.repository.FuncionarioRepository;

@Service
@Transactional(readOnly = true)
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario novo(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> listarTodos() {
		return this.funcionarioRepository.findAll();
	}

}
