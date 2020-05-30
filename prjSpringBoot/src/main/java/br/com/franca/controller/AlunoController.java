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

import br.com.franca.domain.Aluno;
import br.com.franca.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private AlunoService service;

	public AlunoController(AlunoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Aluno> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Aluno findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public Aluno save(@RequestBody Aluno Aluno) {
		return service.save(Aluno);
	}

	@PutMapping
	public Aluno update(@RequestBody Aluno Aluno) {
		return service.update(Aluno);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
