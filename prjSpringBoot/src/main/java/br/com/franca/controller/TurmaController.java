package br.com.franca.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;
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

import br.com.franca.domain.vo.TurmaVO;
import br.com.franca.service.TurmaService;

@RestController
@RequestMapping("/turmas")

public class TurmaController {
	private TurmaService service;

	public TurmaController(TurmaService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public TurmaVO findById(@PathVariable("id") Long id) {
		TurmaVO turmaVO = service.findById(id);
		turmaVO.add(linkTo(methodOn(TurmaController.class).findById(id)).withSelfRel());
		return turmaVO;
	}

	@GetMapping
	public List<TurmaVO> findAll() {
		List<TurmaVO> listaDeUnidadesVO = service.findAll();
		listaDeUnidadesVO.stream()
				.forEach(u -> u.add(linkTo(methodOn(UnidadeController.class).findById(u.getKey())).withSelfRel()));
		return listaDeUnidadesVO;
	}

	@PostMapping
	public TurmaVO save(@RequestBody TurmaVO turmaVO) throws URISyntaxException {
		TurmaVO unidadeSalvaVO = service.save(turmaVO);
		unidadeSalvaVO.add(linkTo(methodOn(UnidadeController.class).findById(unidadeSalvaVO.getKey())).withSelfRel());
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unidadeSalvaVO.getKey()).toUri();
		// return ResponseEntity.created(uri).build();
		return unidadeSalvaVO;
	}

	@PutMapping
	public TurmaVO update(@RequestBody TurmaVO turmaVO) {
		TurmaVO turmaVOAtualizada = service.update(turmaVO);
		turmaVOAtualizada
				.add(linkTo(methodOn(UnidadeController.class).findById(turmaVOAtualizada.getKey())).withSelfRel());
		return turmaVOAtualizada;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
