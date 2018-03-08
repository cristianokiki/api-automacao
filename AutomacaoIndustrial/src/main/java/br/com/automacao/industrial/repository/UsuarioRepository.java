package br.com.automacao.industrial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automacao.industrial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
