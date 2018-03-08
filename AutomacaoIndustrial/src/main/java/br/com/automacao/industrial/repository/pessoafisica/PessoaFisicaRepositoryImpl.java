package br.com.automacao.industrial.repository.pessoafisica;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.automacao.industrial.model.Endereco;
import br.com.automacao.industrial.model.Pessoa;

@Repository
public class PessoaFisicaRepositoryImpl implements PessoaFisicaRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Endereco buscarEnderecoPessoa(Long idPessoa) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Endereco> query = builder.createQuery(Endereco.class);
		Root<Pessoa> root = query.from(Pessoa.class);
		// Join<Pessoa, Endereco> endereco = (Join) root.fetch("endereco");

		// query.where(builder.equal(endereco.get("id"),
		// root.get("endereco").get("id")));

		Predicate predicate = builder.equal(root.get("id"), idPessoa);

		query.where(predicate);
		query.select(
				builder.construct(Endereco.class, root.get("endereco").get("id"), root.get("endereco").get("cidade"),
						root.get("endereco").get("bairro"), root.get("endereco").get("logradouro"),
						root.get("endereco").get("uf"), root.get("endereco").get("complemento"),
						root.get("endereco").get("numero"), root.get("endereco").get("cep")));

		TypedQuery<Endereco> typedQuery = this.entityManager.createQuery(query);
		return typedQuery.getSingleResult();
	}

}
