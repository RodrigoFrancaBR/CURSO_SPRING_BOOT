package br.com.franca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.franca.domain.Parcela;
import br.com.franca.repository.ParcelaRepository;

@Service
public class ParcelaService {
	private ParcelaRepository repository;

	public ParcelaService(ParcelaRepository repository) {
		this.repository = repository;
	}

	public List<Parcela> findAll() {
		return this.repository.findAll();
	}

	public Optional<Parcela> findById(Long id) {
		return this.repository.findById(id);
	}

	public Parcela saveAll (List<Parcela> listaDeParcelas) {
		List<Parcela> listaDeParcelasSalvas = this.repository.saveAll(listaDeParcelas);
		return null;
	}

}
