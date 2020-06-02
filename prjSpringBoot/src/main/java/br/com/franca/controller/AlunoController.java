package br.com.franca.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

import br.com.franca.domain.vo.AlunoVO;
import br.com.franca.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private AlunoService service;

	public AlunoController(AlunoService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public AlunoVO findById(@PathVariable("id") Long id) {
		AlunoVO alunoVO = service.findById(id);
		alunoVO.add(linkTo(methodOn(AlunoController.class).findById(id)).withSelfRel());
		return alunoVO;
	}

	@GetMapping
	public List<AlunoVO> findAll() {
		List<AlunoVO> listaDeAlunosVO = service.findAll();
		listaDeAlunosVO.stream()
				.forEach(u -> u.add(linkTo(methodOn(AlunoController.class).findById(u.getKey())).withSelfRel()));
		return listaDeAlunosVO;
	}

	@PostMapping
	public AlunoVO save(@RequestBody AlunoVO alunoVO) {
		AlunoVO alunoSalvaVO = service.save(alunoVO);
		alunoSalvaVO.add(linkTo(methodOn(AlunoController.class).findById(alunoSalvaVO.getKey())).withSelfRel());
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoSalvaVO.getKey()).toUri();
		// return ResponseEntity.created(uri).build();
		return alunoSalvaVO;
	}

	@PutMapping
	public AlunoVO update(@RequestBody AlunoVO alunoVO) {
		AlunoVO alunoVOAtualizada = service.update(alunoVO);
		alunoVOAtualizada
				.add(linkTo(methodOn(AlunoController.class).findById(alunoVOAtualizada.getKey())).withSelfRel());
		return alunoVOAtualizada;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
