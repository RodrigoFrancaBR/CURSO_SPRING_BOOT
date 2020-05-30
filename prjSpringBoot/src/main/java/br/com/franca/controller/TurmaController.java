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

import br.com.franca.domain.Turma;
import br.com.franca.service.TurmaService;

@RestController
@RequestMapping("/turmas")

public class TurmaController {
	private TurmaService service;

	public TurmaController(TurmaService service) {
		this.service = service;
	}

	@GetMapping
	public List<Turma> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Turma findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public Turma save(@RequestBody Turma Turma) {
		return service.save(Turma);
	}

	@PutMapping
	public Turma update(@RequestBody Turma Turma) {
		return service.update(Turma);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
