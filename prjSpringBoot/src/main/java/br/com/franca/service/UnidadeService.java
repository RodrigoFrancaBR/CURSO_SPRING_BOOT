package br.com.franca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Unidade;
import br.com.franca.domain.enun.Status;
import br.com.franca.exception.ResourceNotFoundException;
import br.com.franca.repository.UnidadeRepository;

@Service
public class UnidadeService {
	private UnidadeRepository repository;

	public UnidadeService(UnidadeRepository repository) {
		this.repository = repository;
	}

	public List<Unidade> findAll() {
		return repository.findAll();
	}

	public Unidade findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Unidade save(Unidade unidade) {
		return repository.save(unidade);
	}

	public Unidade update(Unidade unidade) {
		Unidade unidadeEncontrada = findById(unidade.getId());
		Unidade unidadeAtualizada = getUpdateEntity(unidade, unidadeEncontrada);
		return repository.save(unidadeAtualizada);
	}

	public void delete(Long id) {
		Unidade unidadeEncontrada = findById(id);
		unidadeEncontrada.setStatus(Status.DESATIVADA);
		repository.delete(unidadeEncontrada);
	}

	private Unidade getUpdateEntity(Unidade unidade, Unidade unidadeEncontrada) {
		unidadeEncontrada.setNome(unidade.getNome());
		unidadeEncontrada.setEndereco(unidade.getEndereco());
		unidadeEncontrada.setStatus(unidade.getStatus());
		return unidadeEncontrada;
	}
}
