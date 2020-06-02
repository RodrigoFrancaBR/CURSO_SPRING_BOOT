package br.com.franca.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.franca.domain.vo.ContratoVO;
import br.com.franca.service.ContratoService;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

	private ContratoService service;

	public ContratoController(ContratoService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ContratoVO findById(@PathVariable("id") Long id) {
		ContratoVO contratoVO = service.findById(id);
		contratoVO.add(linkTo(methodOn(ContratoController.class).findById(id)).withSelfRel());
		return contratoVO;
	}

	@GetMapping
	public List<ContratoVO> findAll() {
		List<ContratoVO> listaDeContratosVO = service.findAll();
		listaDeContratosVO.stream().forEach(
				cVO -> cVO.add(linkTo(methodOn(ContratoController.class).findById(cVO.getKey())).withSelfRel()));
		return listaDeContratosVO;
	}

	@PostMapping
	public ContratoVO save(@RequestBody ContratoVO contratoVO) throws Exception {
		ContratoVO contratoSalvaVO = service.save(contratoVO);
		contratoSalvaVO
				.add(linkTo(methodOn(ContratoController.class).findById(contratoSalvaVO.getKey())).withSelfRel());
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contratoSalvaVO.getKey()).toUri();
		// return ResponseEntity.created(uri).build();
		return contratoSalvaVO;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
