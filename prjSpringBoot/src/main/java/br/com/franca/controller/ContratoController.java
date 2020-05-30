package br.com.franca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.domain.Contrato;
import br.com.franca.service.ContratoService;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

	private ContratoService service;

	public ContratoController(ContratoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Contrato> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Contrato findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public Contrato save(@RequestBody Contrato Contrato) throws Exception {
		return service.save(Contrato);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
