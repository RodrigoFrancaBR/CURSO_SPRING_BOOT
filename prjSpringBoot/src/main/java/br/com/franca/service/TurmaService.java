package br.com.franca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Turma;
import br.com.franca.domain.converter.DozerConverter;
import br.com.franca.domain.enun.Status;
import br.com.franca.domain.vo.TurmaVO;
import br.com.franca.exception.ResourceNotFoundException;
import br.com.franca.repository.TurmaRepository;

@Service
public class TurmaService {

	private TurmaRepository repository;

	public TurmaService(TurmaRepository repository) {
		this.repository = repository;
	}

	public TurmaVO findById(Long id) {
		Turma turma = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(turma, TurmaVO.class);
	}

	public List<TurmaVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), TurmaVO.class);
	}

	public TurmaVO save(TurmaVO turmaVO) {
		Turma turma = DozerConverter.parseObject(turmaVO, Turma.class);
		return DozerConverter.parseObject(repository.save(turma), TurmaVO.class);
	}

	public TurmaVO update(TurmaVO turmaVO) {
		findById(turmaVO.getKey());
		Turma turmaAtualizada = repository.save(DozerConverter.parseObject(turmaVO, Turma.class));
		return DozerConverter.parseObject(turmaAtualizada, TurmaVO.class);
	}

	public void delete(Long id) {
		TurmaVO turmaEncontrada = findById(id);
		turmaEncontrada.setStatus(Status.DESATIVADA);
		repository.delete(DozerConverter.parseObject(turmaEncontrada, Turma.class));
	}

}
