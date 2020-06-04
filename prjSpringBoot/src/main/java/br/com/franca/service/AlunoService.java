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
		AlunoVO alunoEncontradoVO = findById(alunoVO.getKey());
		AlunoVO alunoAtualizadoVO = getUpdateEntity(alunoVO, alunoEncontradoVO);
		Aluno alunoAtualizado = repository.save(DozerConverter.parseObject(alunoAtualizadoVO, Aluno.class));
		return DozerConverter.parseObject(alunoAtualizado, AlunoVO.class);
	}

	public void delete(Long id) {
		AlunoVO alunoEncontrado = findById(id);
		alunoEncontrado.setSituacaoAluno(SituacaoAluno.INATIVO);
		repository.delete(DozerConverter.parseObject(alunoEncontrado, Aluno.class));
	}
	
	private AlunoVO getUpdateEntity(AlunoVO alunoVO, AlunoVO alunoEncontradoVO) {
		alunoEncontradoVO.setNome(alunoVO.getNome());
		alunoEncontradoVO.setSituacaoAluno(alunoVO.getSituacaoAluno());

		return alunoEncontradoVO;
	}

}
