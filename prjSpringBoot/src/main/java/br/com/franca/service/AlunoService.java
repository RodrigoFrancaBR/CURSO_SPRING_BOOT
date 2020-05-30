package br.com.franca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Aluno;
import br.com.franca.domain.enun.SituacaoAluno;
import br.com.franca.exception.ResourceNotFoundException;
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

	public Aluno findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Aluno save(Aluno aluno) {
		return this.repository.save(aluno);
	}

	public Aluno update(Aluno aluno) {
		Aluno alunoEncontrado = findById(aluno.getId());
		Aluno alunoAtualizado = getUpdateEntity(aluno, alunoEncontrado);
		return repository.save(alunoAtualizado);
	}	

	public void delete(Long id) {
		Aluno alunoEncontrada = findById(id);
		alunoEncontrada.setSituacaoAluno(SituacaoAluno.INATIVO);
		repository.delete(alunoEncontrada);
	}

	private Aluno getUpdateEntity(Aluno aluno, Aluno alunoEncontrado) {
		alunoEncontrado.setNome(aluno.getNome());
		alunoEncontrado.setEndereco(aluno.getEndereco());
		alunoEncontrado.setSituacaoAluno(aluno.getSituacaoAluno());
		
		// add os outros atributos
		return alunoEncontrado;
	}

}
