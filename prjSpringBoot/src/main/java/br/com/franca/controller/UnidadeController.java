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

import br.com.franca.domain.vo.UnidadeVO;
import br.com.franca.service.UnidadeService;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	private UnidadeService service;

	@GetMapping("/{id}")
	public UnidadeVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	public UnidadeController(UnidadeService service) {
		this.service = service;
	}

	@GetMapping
	public List<UnidadeVO> findAll() {
		return service.findAll();
	}

	@PostMapping
	public UnidadeVO save(@RequestBody UnidadeVO unidadeVO) {
		return service.save(unidadeVO);
	}

	@PutMapping
	public UnidadeVO update(@RequestBody UnidadeVO unidadeVO) {
		return service.update(unidadeVO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
