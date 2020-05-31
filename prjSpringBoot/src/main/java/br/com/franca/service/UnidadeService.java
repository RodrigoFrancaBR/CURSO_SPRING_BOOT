package br.com.franca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Unidade;
import br.com.franca.domain.converter.DozerConverter;
import br.com.franca.domain.enun.Status;
import br.com.franca.domain.vo.UnidadeVO;
import br.com.franca.exception.ResourceNotFoundException;
import br.com.franca.repository.UnidadeRepository;

@Service
public class UnidadeService {
	private UnidadeRepository repository;

	public UnidadeService(UnidadeRepository repository) {
		this.repository = repository;
	}

	public List<UnidadeVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), UnidadeVO.class);		
	}

	public UnidadeVO findById(Long id) {
		Unidade unidade = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(unidade, UnidadeVO.class);
	}

	public UnidadeVO save(UnidadeVO unidadeVO) {
		Unidade unidade = DozerConverter.parseObject(unidadeVO, Unidade.class);
		return DozerConverter.parseObject(repository.save(unidade), UnidadeVO.class);
	}

	public UnidadeVO update(UnidadeVO unidadeVO) {		
		findById(unidadeVO.getId());
		Unidade unidadeAtualizada = repository.save(DozerConverter.parseObject(unidadeVO, Unidade.class));
		return DozerConverter.parseObject(unidadeAtualizada, UnidadeVO.class);		
	}

	public void delete(Long id) {
		UnidadeVO unidadeEncontrada = findById(id);
		unidadeEncontrada.setStatus(Status.DESATIVADA);
		repository.delete(DozerConverter.parseObject(unidadeEncontrada, Unidade.class));
	}
}
