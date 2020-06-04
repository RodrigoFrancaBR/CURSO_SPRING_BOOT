package br.com.franca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.franca.domain.Turma;
import br.com.franca.domain.Unidade;
import br.com.franca.domain.converter.DozerConverter;
import br.com.franca.domain.enun.Status;
import br.com.franca.domain.vo.TurmaVO;
import br.com.franca.domain.vo.UnidadeVO;
import br.com.franca.exception.ResourceNotFoundException;
import br.com.franca.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private UnidadeService unidadeService;

	private TurmaRepository repository;

	public TurmaService(TurmaRepository repository) {
		this.repository = repository;
	}

	public TurmaVO findById(Long id) {
		Turma turma = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));		
		return obterTurmaVO(turma);
	}

	public List<TurmaVO> findAll() {
		List<Turma> listaDeTurmas = repository.findAll();
		return obterListaDeTurmaVO(listaDeTurmas);
	}

	public TurmaVO save(TurmaVO turmaVO) {
		UnidadeVO unidadeEncontradaVO = unidadeService.findById(turmaVO.getUnidadeVO().getKey());
		turmaVO.setUnidadeVO(unidadeEncontradaVO);
		Turma turma = obterTurma(turmaVO);
		return obterTurmaVO(repository.save(turma));
	}	

	public TurmaVO update(TurmaVO turmaVO) {
		TurmaVO turmaEncontradaVO = findById(turmaVO.getKey());
		TurmaVO turmaAtualizadaVO = getUpdateEntity(turmaVO, turmaEncontradaVO);
		Turma turma = obterTurma(turmaAtualizadaVO);
		return obterTurmaVO(repository.save(turma));		
	}

	public void delete(Long id) {
		TurmaVO turmaEncontradaVO = findById(id);
		turmaEncontradaVO.setStatus(Status.DESATIVADA);		
		repository.save(obterTurma(turmaEncontradaVO));
	}

	private TurmaVO getUpdateEntity(TurmaVO turmaVO, TurmaVO turmaEncontradaVO) {
		turmaEncontradaVO.setNome(turmaVO.getNome());
		turmaEncontradaVO.setStatus(turmaVO.getStatus());
		return turmaEncontradaVO;
	}
	
	private Turma obterTurma(TurmaVO turmaVO) {
		Turma turma = null;
		turma = DozerConverter.parseObject(turmaVO, Turma.class);
		Unidade unidade = DozerConverter.parseObject(turmaVO.getUnidadeVO(), Unidade.class);
		turma.setUnidade(unidade);
		return turma;
	}

	private TurmaVO obterTurmaVO(Turma turma) {
		TurmaVO turmaVO = null;
		UnidadeVO unidadeVO = DozerConverter.parseObject(turma.getUnidade(), UnidadeVO.class);
		turmaVO = DozerConverter.parseObject(turma, TurmaVO.class);
		turmaVO.setUnidadeVO(unidadeVO);
		return turmaVO;
	}

	private List<TurmaVO> obterListaDeTurmaVO(List<Turma> turmas) {
		List<TurmaVO> listaDeTurmasVO = new ArrayList<>();
		for (Turma turma : turmas) {
			UnidadeVO unidadeVO = DozerConverter.parseObject(turma.getUnidade(), UnidadeVO.class);
			TurmaVO turmaVO = DozerConverter.parseObject(turma, TurmaVO.class);
			turmaVO.setUnidadeVO(unidadeVO);
			listaDeTurmasVO.add(turmaVO);
		}
		return listaDeTurmasVO; 
	}

}
