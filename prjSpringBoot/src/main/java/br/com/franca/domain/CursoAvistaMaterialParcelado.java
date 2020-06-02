package br.com.franca.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.franca.domain.enun.SituacaoParcela;
import br.com.franca.domain.vo.ContratoVO;
import br.com.franca.domain.vo.ParcelaVO;

public class CursoAvistaMaterialParcelado extends CondicaoDeContrato {

	@Override
	public List<ParcelaVO> calcularParcelas(ContratoVO contratoVO) {

		ParcelaVO parcelaVO = new ParcelaVO();

		List<ParcelaVO> parcelaVOs = new ArrayList<ParcelaVO>();

		BigDecimal desconto = contratoVO.getValorCurso().multiply(BigDecimal.valueOf(contratoVO.getDescontoCurso()));

		BigDecimal cursoComDescontoAvista = contratoVO.getValorCurso().subtract(desconto);

		BigDecimal parcelaVODoMaterial = contratoVO.getValorMaterial()
				.divide(BigDecimal.valueOf(contratoVO.getQtdParcelasMaterial()), 2, BigDecimal.ROUND_DOWN);

		BigDecimal residualDaParcelaVOMaterial = contratoVO.getValorMaterial()
				.subtract(parcelaVODoMaterial.multiply(BigDecimal.valueOf(contratoVO.getQtdParcelasMaterial())));

		parcelaVO.setDataVencimento(Calendar.getInstance());

		Calendar proximoVencimento = Calendar.getInstance();

		parcelaVO.setValorParcelaMaterial(BigDecimal.valueOf(0));

		parcelaVO.setValorParcelaCurso(cursoComDescontoAvista.add(contratoVO.getTaxaMatricula()));

		parcelaVO.setValorTotalParcela(parcelaVO.getValorParcelaCurso());

		parcelaVO.setValorPago(parcelaVO.getValorTotalParcela());

		parcelaVO.setDataPagamento(Calendar.getInstance());

		parcelaVO.setSituacaoParcela(SituacaoParcela.PAGO);

		parcelaVOs.add(parcelaVO);

		int diferenca = Math.abs(contratoVO.getDiaVencimento() - Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

		if (diferenca >= 20)
			proximoVencimento.add(Calendar.MONTH, 1);

		for (int i = 1; i <= contratoVO.getQtdParcelasMaterial(); i++) {

			parcelaVO = new ParcelaVO();

			proximoVencimento = Calendar.getInstance();

			proximoVencimento.set(Calendar.DAY_OF_MONTH, contratoVO.getDiaVencimento());

			proximoVencimento.add(Calendar.MONTH, i);

			parcelaVO.setDataVencimento(proximoVencimento);

			parcelaVO.setValorParcelaCurso((BigDecimal.valueOf(0)));

			parcelaVO.setValorParcelaMaterial(parcelaVODoMaterial);

			if (i == contratoVO.getQtdParcelasMaterial())
				parcelaVO.setValorParcelaMaterial(parcelaVODoMaterial.add(residualDaParcelaVOMaterial));

			parcelaVO.setValorTotalParcela(parcelaVO.getValorParcelaMaterial());

			parcelaVO.setValorPago(BigDecimal.valueOf(0));

			parcelaVO.setDataPagamento(null);

			parcelaVO.setSituacaoParcela(SituacaoParcela.A_VENCER);

			parcelaVOs.add(parcelaVO);
		}
		return parcelaVOs;
	}
}
