package br.com.automacao.industrial.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automacao.industrial.model.Cargo;
import br.com.automacao.industrial.service.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoResource {

	@Autowired
	private CargoService cargoService;

	@GetMapping
	public ResponseEntity<List<Cargo>> buscar() {

		List<Cargo> cargos = this.cargoService.buscarTodosCargos();

		return ResponseEntity.ok(cargos);
	}

	@PostMapping
	public ResponseEntity<Cargo> novo(@RequestBody @Valid Cargo cargo) {

		Cargo cargoNovo = this.cargoService.novo(cargo);

		return ResponseEntity.status(HttpStatus.CREATED).body(cargoNovo);
	}

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<Object> handleValidationGenericException(MethodArgumentNotValidException ex) {

		List<Erro> erros = this.criarListaErro(ex.getBindingResult());

		return ResponseEntity.badRequest().body(erros);
	}

	public List<Erro> criarListaErro(BindingResult result) {
		List<Erro> erros = new ArrayList<>();

		for (FieldError erro : result.getFieldErrors()) {
			String usuario = this.messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			String desenvolvedor = erro.toString();

			erros.add(new Erro(usuario, desenvolvedor));
		}
		return erros;
	}

	class Erro {
		private String mensagemUsuario;
		private String mensagemDesenvolvedor;

		public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
			this.mensagemUsuario = mensagemUsuario;
		}

		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}

		public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}

		public String getMensagemUsuario() {
			return mensagemUsuario;
		}

		public void setMensagemUsuario(String mensagemUsuario) {
			this.mensagemUsuario = mensagemUsuario;
		}

	}
}