package br.com.automacao.industrial.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automacao.industrial.model.Endereco;
import br.com.automacao.industrial.model.PessoaFisica;
import br.com.automacao.industrial.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoaFisica")
public class PessoaFisicaResource {

	@Autowired
	private PessoaFisicaService pessoaFisicaService;

	@PostMapping
	public ResponseEntity<PessoaFisica> salvar(@RequestBody @Valid PessoaFisica pessoaFisica) {

		PessoaFisica pessoaFisicaSalva = this.pessoaFisicaService.salvar(pessoaFisica);

		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisicaSalva);
	}

	@GetMapping
	public ResponseEntity<List<PessoaFisica>> buscarTodasPessoas() {
		List<PessoaFisica> lista = this.pessoaFisicaService.buscarTodasPessoas();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}/endereco")
	public ResponseEntity<Endereco> buscarEnderecoPessoa(@PathVariable Long id){
		Endereco enderecoPessoaFisica = this.pessoaFisicaService.buscarEnderecoPessoaFisica(id);
		
		return enderecoPessoaFisica != null ? ResponseEntity.ok(enderecoPessoaFisica) : ResponseEntity.notFound().build();
		
	}

}
