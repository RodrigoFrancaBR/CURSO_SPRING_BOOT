package br.com.franca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.franca.domain.Contrato;
import br.com.franca.domain.Parcela;
import br.com.franca.repository.ContratoRepository;

@Service
public class ContratoService {
	@Autowired
	private ParcelaService parcelaService;

	private ContratoRepository contratoRepository;

	public ContratoService(ContratoRepository repository) {
		this.contratoRepository = repository;
	}

	public List<Contrato> findAll() {
		return this.contratoRepository.findAll();
	}

	public Optional<Contrato> findById(Long id) {
		return this.contratoRepository.findById(id);
	}

	public Contrato save(Contrato contrato, List<Parcela> listaDeParcelas) {
		Contrato contratoSalvo = contratoRepository.save(contrato);
		if (contratoSalvo != null) {
			parcelaService.saveAll(listaDeParcelas);
		}
		return null;
	}

	public Optional<Contrato> delete(Long id) {
		return this.contratoRepository.findById(id).map(c -> {
			this.contratoRepository.delete(c);
			return c;
		});
	}

}
