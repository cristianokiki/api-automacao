package br.com.automacao.industrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.industrial.model.PessoaJuridica;
import br.com.automacao.industrial.repository.PessoaJuridicaRepository;

@Service
@Transactional(readOnly = true)
public class PessoaJuridicaService {

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	public PessoaJuridica novo(PessoaJuridica pessoaJuridica) {
		return this.pessoaJuridicaRepository.save(pessoaJuridica);
	}

	public List<PessoaJuridica> listaTodos() {
		return this.pessoaJuridicaRepository.findAll();
	}
}
