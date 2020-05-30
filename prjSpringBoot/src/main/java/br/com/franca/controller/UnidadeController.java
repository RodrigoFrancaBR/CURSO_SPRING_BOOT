package br.com.franca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.domain.Unidade;
import br.com.franca.service.UnidadeService;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {
		
	private UnidadeService service;
	
	public UnidadeController(UnidadeService service) {
		this.service = service;
	}

	@GetMapping
	public List<Unidade> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Unidade findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public Unidade save(@RequestBody Unidade Unidade) {
		return service.save(Unidade);
	}

	@PutMapping
	public Unidade update(@RequestBody Unidade Unidade) {
		return service.update(Unidade);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
