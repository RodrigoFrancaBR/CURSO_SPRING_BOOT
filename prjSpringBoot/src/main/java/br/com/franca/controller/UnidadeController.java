package br.com.franca.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//@CrossOrigin
@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	private UnidadeService service;

	public UnidadeController(UnidadeService service) {
		this.service = service;
	}
	// @CrossOrigin(origins="http://localhost:8080")
	@GetMapping("/{id}")
	public UnidadeVO findById(@PathVariable("id") Long id) {
		UnidadeVO unidadeVO = service.findById(id);
		unidadeVO.add(linkTo(methodOn(UnidadeController.class).findById(id)).withSelfRel());
		return unidadeVO;
	}
	
	@GetMapping
	public List<UnidadeVO> findAll() {
		List<UnidadeVO> listaDeUnidadesVO = service.findAll();
		listaDeUnidadesVO.stream()
				.forEach(u -> u.add(linkTo(methodOn(UnidadeController.class).findById(u.getKey())).withSelfRel()));
		return listaDeUnidadesVO;
	}

	@PostMapping
	public UnidadeVO save(@RequestBody UnidadeVO unidadeVO) {
		UnidadeVO unidadeSalvaVO = service.save(unidadeVO);
		unidadeSalvaVO.add(linkTo(methodOn(UnidadeController.class).findById(unidadeSalvaVO.getKey())).withSelfRel());
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unidadeSalvaVO.getKey()).toUri();
		// return ResponseEntity.created(uri).build();
		return unidadeSalvaVO;
	}

	@PutMapping
	public UnidadeVO update(@RequestBody UnidadeVO unidadeVO) {
		UnidadeVO unidadeVOAtualizada = service.update(unidadeVO);
		unidadeVOAtualizada
				.add(linkTo(methodOn(UnidadeController.class).findById(unidadeVOAtualizada.getKey())).withSelfRel());
		return unidadeVOAtualizada;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
