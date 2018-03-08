package br.com.automacao.industrial.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("U")
public class Usuario extends Funcionario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Size(max = 50)
	@Column(name = "LOGIN", length = 50)
	private String login;

	@Size(max = 30)
	@Column(name = "SENHA", length = 150)
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_PERMISSAO", 
		joinColumns = @JoinColumn(name = "CODIGO_USUARIO"), 
		inverseJoinColumns = @JoinColumn(name = "CODIGO_PERMISSAO"))
	private List<Permissao> permissoes;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}




	
}
