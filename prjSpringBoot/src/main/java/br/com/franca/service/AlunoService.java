package br.com.franca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Aluno;
import br.com.franca.domain.converter.DozerConverter;
import br.com.franca.domain.enun.SituacaoAluno;
import br.com.franca.domain.vo.AlunoVO;
import br.com.franca.exception.ResourceNotFoundException;
import br.com.franca.repository.AlunoRepository;

@Service
public class AlunoService {
	private AlunoRepository repository;

	public AlunoService(AlunoRepository repository) {
		this.repository = repository;
	}

	public AlunoVO findById(Long id) {
		Aluno aluno = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(aluno, AlunoVO.class);
	}

	public List<AlunoVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), AlunoVO.class);
	}

	public AlunoVO save(AlunoVO alunoVO) {
		Aluno aluno = DozerConverter.parseObject(alunoVO, Aluno.class);
		return DozerConverter.parseObject(repository.save(aluno), AlunoVO.class);
	}

	public AlunoVO update(AlunoVO alunoVO) {
		findById(alunoVO.getKey());
		Aluno alunoAtualizada = repository.save(DozerConverter.parseObject(alunoVO, Aluno.class));
		return DozerConverter.parseObject(alunoAtualizada, AlunoVO.class);
	}

	public void delete(Long id) {
		AlunoVO alunoEncontrado = findById(id);
		alunoEncontrado.setSituacaoAluno(SituacaoAluno.INATIVO);
		repository.delete(DozerConverter.parseObject(alunoEncontrado, Aluno.class));
	}

}
