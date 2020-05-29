package br.com.franca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Aluno;
import br.com.franca.repository.AlunoRepository;

@Service
public class AlunoService {
	private AlunoRepository repository;

	public AlunoService(AlunoRepository repository) {
		this.repository = repository;
	}

	public List<Aluno> findAll() {
		return this.repository.findAll();
	}

	public Optional<Aluno> findById(Long id) {
		return this.repository.findById(id);

	}

	public Aluno save(Aluno aluno) {
		return this.repository.save(aluno);
	}

	public Optional<Aluno> update(Aluno aluno) {
		return findById(aluno.getId()).map(a -> {
			a.setNome(aluno.getNome());
			a.setEndereco(aluno.getEndereco());
			a.setSituacaoAluno(aluno.getSituacaoAluno());
			return this.repository.save(a);
		});
	}

	public Optional<Aluno> delete(Long id) {
		return this.repository.findById(id).map(u -> {
			this.repository.delete(u);
			return u;
		});
	}

}
