package br.com.automacao.industrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.industrial.model.Endereco;
import br.com.automacao.industrial.model.PessoaFisica;
import br.com.automacao.industrial.repository.pessoafisica.PessoaFisicaRepository;

@Service
@Transactional(readOnly = false)
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository pessoaRepository;
	
	public PessoaFisica salvar(PessoaFisica pessoa) {
		return this.pessoaRepository.save(pessoa);
	}
	
	public List<PessoaFisica> buscarTodasPessoas(){
		return this.pessoaRepository.findAll();
	}
	
	public Endereco buscarEnderecoPessoaFisica(Long id) {
		return this.pessoaRepository.buscarEnderecoPessoa(id);
	}
	
}
