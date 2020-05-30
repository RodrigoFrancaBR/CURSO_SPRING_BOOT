package br.com.franca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Turma;
import br.com.franca.domain.enun.Status;
import br.com.franca.exception.ResourceNotFoundException;
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

	public Turma findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Turma save(Turma turma) {
		return repository.save(turma);
	}

	public Turma update(Turma turma) {
		Turma turmaEncontrada = findById(turma.getId());
		Turma turmaAtualizada = getUpdateEntity(turma, turmaEncontrada);
		return repository.save(turmaAtualizada);
	}

	public void delete(Long id) {
		Turma turmaEncontrada = findById(id);
		turmaEncontrada.setStatus(Status.DESATIVADA);
		repository.delete(turmaEncontrada);
	}

	private Turma getUpdateEntity(Turma turma, Turma turmaEncontrada) {
		turmaEncontrada.setNome(turma.getNome());		
		turmaEncontrada.setStatus(turma.getStatus());
		return turmaEncontrada;
	}

}
