package br.com.franca;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {
	@RequestMapping("/pessoa")
	public Pessoa getPessoa(@RequestParam (value="nome", defaultValue="Nome não Informado")String nome) {		
		return new Pessoa(nome, "meu_email@gmail.com");
	}

}
