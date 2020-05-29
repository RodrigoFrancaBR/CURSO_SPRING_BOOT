package br.com.franca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Turma;
import br.com.franca.repository.TurmaRepository;

@Service
public class TurmaService {
	private TurmaRepository repository;

	public TurmaService(TurmaRepository repository) {
		this.repository = repository;
	}

	public List<Turma> findAll() {
		return repository.findAll();
	}

	public Optional<Turma> findById(Long id) {
		return repository.findById(id);
	}

	public Turma save(Turma turma) {
		return repository.save(turma);
	}

	public Optional<Turma> update(Turma turma) {
		return findById(turma.getId()).map(t -> {
			t.setNome(turma.getNome());
			t.setStatus(turma.getStatus());
			return this.repository.save(t);
		});
	}

	public Optional<Turma> delete(Long id) {
		return this.repository.findById(id).map(u -> {
			this.repository.delete(u);
			return u;
		});
	}

}
