package br.com.automacao.industrial.repository.pessoafisica;

import br.com.automacao.industrial.model.Endereco;

public interface PessoaFisicaRepositoryQuery {

	public Endereco buscarEnderecoPessoa(Long idPessoa);

}
