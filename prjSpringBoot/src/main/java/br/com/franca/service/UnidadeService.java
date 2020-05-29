package br.com.franca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Unidade;
import br.com.franca.repository.UnidadeRepository;

@Service
public class UnidadeService {
	private UnidadeRepository repository;

	public UnidadeService(UnidadeRepository repository) {
		this.repository = repository;
	}

	public List<Unidade> findAll() {
		return this.repository.findAll();
	}

	public Optional<Unidade> findById(Long id) {
		return this.repository.findById(id);
	}

	public Unidade save(Unidade unidade) {
		return this.repository.save(unidade);
	}

	public Optional<Unidade> update(Unidade unidade) {
		return findById(unidade.getId()).map(u -> {
			u.setNome(unidade.getNome());
			u.setEndereco(unidade.getEndereco());
			u.setStatus(unidade.getStatus());
			return this.repository.save(u);
		});
	}

	public Optional<Unidade> delete(Long id) {
		return this.repository.findById(id).map(u -> {
			this.repository.delete(u);
			return u;
		});
	}
}
