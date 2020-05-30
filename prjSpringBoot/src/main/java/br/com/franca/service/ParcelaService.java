package br.com.franca.service;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Parcela;
import br.com.franca.repository.ParcelaRepository;

@Service
public class ParcelaService {
	private ParcelaRepository repository;

	public ParcelaService(ParcelaRepository repository) {
		this.repository = repository;
	}

	public void save(Parcela parcela) {
		repository.save(parcela);
	}

}
