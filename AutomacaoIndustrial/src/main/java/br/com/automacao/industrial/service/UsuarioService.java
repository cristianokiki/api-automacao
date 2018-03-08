package br.com.automacao.industrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.automacao.industrial.model.Usuario;
import br.com.automacao.industrial.repository.UsuarioRepository;

@Service
@Transactional(readOnly = true)
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario novo(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	public List<Usuario> listarTodos() {
		return this.usuarioRepository.findAll();
	}

}
