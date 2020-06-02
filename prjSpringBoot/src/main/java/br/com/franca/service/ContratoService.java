package br.com.franca.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.franca.domain.CondicaoDeContrato;
import br.com.franca.domain.Contrato;
import br.com.franca.domain.converter.DozerConverter;
import br.com.franca.domain.enun.FormaPagamento;
import br.com.franca.domain.enun.SituacaoMatricula;
import br.com.franca.domain.vo.AlunoVO;
import br.com.franca.domain.vo.ContratoVO;
import br.com.franca.domain.vo.ParcelaVO;
import br.com.franca.domain.vo.TurmaVO;
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

	public ContratoVO findById(Long id) {
		Contrato contrato = contratoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(contrato, ContratoVO.class);
	}

	public List<ContratoVO> findAll() {
		return DozerConverter.parseListObjects(contratoRepository.findAll(), ContratoVO.class);
	}

	public ContratoVO save(ContratoVO contratoVo) throws Exception {

		AlunoVO alunoVO = alunoService.findById(contratoVo.getAlunoVO().getKey());
		TurmaVO turmaVO = turmaService.findById(contratoVo.getTurmaVO().getKey());

		contratoVo.setAlunoVO(alunoVO);
		contratoVo.setTurmaVO(turmaVO);

		contratoVo.setMatricula(obterMatricula(contratoVo));

		List<ParcelaVO> listaDeParcelasVO = simularContrato(contratoVo);

		contratoVo.setSituacaoMatricula(SituacaoMatricula.ATIVA);

		Contrato contrato = DozerConverter.parseObject(contratoVo, Contrato.class);

		ContratoVO contratoVOSalvo = DozerConverter.parseObject(contratoRepository.save(contrato), ContratoVO.class);

		// contratoVo contratoSalvo = contratoRepository.save(contrato);

		// configurar id do contrato nas parcelas
		listaDeParcelasVO.forEach(pVO -> pVO.setContratoVO(contratoVOSalvo));

		listaDeParcelasVO.forEach(parcelaService::save);

		return contratoVOSalvo;
	}

	public void delete(Long id) {
		ContratoVO contratoEncontrado = findById(id);
		contratoEncontrado.setSituacaoMatricula(SituacaoMatricula.CANCELADA);
		contratoRepository.delete(DozerConverter.parseObject(contratoEncontrado, Contrato.class));
	}

	private String obterMatricula(ContratoVO contratoVo) {
		int anoAtual = contratoVo.getDataMatricula().get(Calendar.YEAR);
		String cpfInicio = contratoVo.getAlunoVO().getCpf().substring(0, 3);
		String turmaNome = contratoVo.getTurmaVO().getNome();
		String matricula = anoAtual + cpfInicio + turmaNome;
		return matricula;
	}

	public List<ParcelaVO> simularContrato(ContratoVO contratoVO) throws Exception {

		if (contratoVO.getDescontoCurso() == null)
			contratoVO.setDescontoCurso(0.0);

		if (contratoVO.getTaxaMatricula() == null)
			contratoVO.setTaxaMatricula(BigDecimal.valueOf(0));

		if (contratoVO.getDiaVencimento() == null)
			contratoVO.setDiaVencimento(Calendar.getInstance().DAY_OF_YEAR);

		if (contratoVO.getFormaPagamento() == null)
			contratoVO.setFormaPagamento(FormaPagamento.DINHEIRO);

		if (contratoVO.getValorCurso() == null)
			throw new Exception("Valor do curso é null.");

		if (contratoVO.getValorMaterial() == null)
			throw new Exception("Valor do material é null.");

		if (contratoVO.getQtdParcelasCurso() == null)
			throw new Exception("Quantidade de Parcelas do Curso é null.");

		if (contratoVO.getQtdParcelasMaterial() == null)
			throw new Exception("Quantidade de Parcelas do Material é null.");

		return CondicaoDeContrato.getParcelas(contratoVO);
	}

}
