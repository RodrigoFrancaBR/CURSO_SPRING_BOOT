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
import br.com.franca.domain.vo.UnidadeVO;
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
		UnidadeVO unidadeVO = turmaVO.getUnidadeVO();
		unidadeVO.add(linkTo(methodOn(UnidadeController.class).findById(unidadeVO.getKey())).withSelfRel());
		turmaVO.setUnidadeVO(unidadeVO);
		turmaVO.add(linkTo(methodOn(TurmaController.class).findById(id)).withSelfRel());
		return turmaVO;
	}

	@GetMapping
	public List<TurmaVO> findAll() {
		List<TurmaVO> listaDeTurmasVO = service.findAll();
		listaDeTurmasVO.stream()
				.forEach(tVO -> tVO.add(linkTo(methodOn(TurmaController.class).findById(tVO.getKey())).withSelfRel()));
		return listaDeTurmasVO;
	}

	@PostMapping
	public TurmaVO save(@RequestBody TurmaVO turmaVO) throws URISyntaxException {
		TurmaVO turmaSalvaVO = service.save(turmaVO);
		turmaSalvaVO.add(linkTo(methodOn(TurmaController.class).findById(turmaSalvaVO.getKey())).withSelfRel());
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unidadeSalvaVO.getKey()).toUri();
		// return ResponseEntity.created(uri).build();
		return turmaSalvaVO;
	}

	@PutMapping
	public TurmaVO update(@RequestBody TurmaVO turmaVO) {
		TurmaVO turmaVOAtualizada = service.update(turmaVO);
		turmaVOAtualizada
				.add(linkTo(methodOn(TurmaController.class).findById(turmaVOAtualizada.getKey())).withSelfRel());
		return turmaVOAtualizada;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
