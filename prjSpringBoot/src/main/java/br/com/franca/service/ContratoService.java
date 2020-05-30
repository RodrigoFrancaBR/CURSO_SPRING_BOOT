package br.com.franca.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.franca.domain.Aluno;
import br.com.franca.domain.CondicaoDeContrato;
import br.com.franca.domain.Contrato;
import br.com.franca.domain.Parcela;
import br.com.franca.domain.Turma;
import br.com.franca.domain.enun.FormaPagamento;
import br.com.franca.domain.enun.SituacaoMatricula;
import br.com.franca.exception.ResourceNotFoundException;
import br.com.franca.repository.ContratoRepository;

@Service
public class ContratoService {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private ParcelaService parcelaService;

	private ContratoRepository contratoRepository;

	public ContratoService(ContratoRepository contratoRepository) {
		this.contratoRepository = contratoRepository;
	}

	public List<Contrato> findAll() {
		return this.contratoRepository.findAll();
	}

	public Contrato findById(Long id) {
		return contratoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Contrato save(Contrato contrato) throws Exception {

		Aluno aluno = alunoService.findById(contrato.getAluno().getId());
		Turma turma = turmaService.findById(contrato.getTurma().getId());

		contrato.setAluno(aluno);
		contrato.setTurma(turma);

		contrato.setMatricula(obterMatricula(contrato));
		
			List<Parcela> listaDeParcelas = simularContrato(contrato);

			contrato.setSituacaoMatricula(SituacaoMatricula.ATIVA);

			Contrato contratoSalvo = contratoRepository.save(contrato);

			// configurar id do contrato nas parcelas
			listaDeParcelas.forEach(p -> p.setContrato(contratoSalvo));

			listaDeParcelas.forEach(parcelaService::save);

			return contratoSalvo;
	}

	public void delete(Long id) {
		Contrato contratoEncontrado = findById(id);
		contratoEncontrado.setSituacaoMatricula(SituacaoMatricula.CANCELADA);
		contratoRepository.save(contratoEncontrado);
	}

	private String obterMatricula(Contrato contrato) {
		int anoAtual = contrato.getDataMatricula().get(Calendar.YEAR);
		String cpfInicio = contrato.getAluno().getCpf().substring(0, 3);
		String turmaNome = contrato.getTurma().getNome();
		String matricula = anoAtual + cpfInicio + turmaNome;
		return matricula;
	}

	public List<Parcela> simularContrato(Contrato contrato) throws Exception {

		if (contrato.getDescontoCurso() == null)
			contrato.setDescontoCurso(0.0);

		if (contrato.getTaxaMatricula() == null)
			contrato.setTaxaMatricula(BigDecimal.valueOf(0));

		if (contrato.getDiaVencimento() == null)
			contrato.setDiaVencimento(Calendar.getInstance().DAY_OF_YEAR);

		if (contrato.getFormaPagamento() == null)
			contrato.setFormaPagamento(FormaPagamento.DINHEIRO);

		if (contrato.getValorCurso() == null)
			throw new Exception("Valor do curso é null.");

		if (contrato.getValorMaterial() == null)
			throw new Exception("Valor do material é null.");

		if (contrato.getQtdParcelasCurso() == null)
			throw new Exception("Quantidade de Parcelas do Curso é null.");

		if (contrato.getQtdParcelasMaterial() == null)
			throw new Exception("Quantidade de Parcelas do Material é null.");

		return CondicaoDeContrato.getParcelas(contrato);
	}

}
