package br.com.franca.service;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Parcela;
import br.com.franca.domain.converter.DozerConverter;
import br.com.franca.domain.vo.ParcelaVO;
import br.com.franca.repository.ParcelaRepository;

@Service
public class ParcelaService {
	private ParcelaRepository repository;

	public ParcelaService(ParcelaRepository repository) {
		this.repository = repository;
	}

	public ParcelaVO save(ParcelaVO parcelaVO) {
		Parcela parcela = DozerConverter.parseObject(parcelaVO, Parcela.class);
		// repository.save(parcela);
		return DozerConverter.parseObject(repository.save(parcela), ParcelaVO.class);
	}

}
