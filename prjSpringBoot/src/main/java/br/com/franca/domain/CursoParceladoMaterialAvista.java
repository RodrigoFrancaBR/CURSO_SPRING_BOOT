package br.com.franca.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.franca.domain.enun.SituacaoParcela;
import br.com.franca.domain.vo.ContratoVO;
import br.com.franca.domain.vo.ParcelaVO;

public class CursoParceladoMaterialAvista extends CondicaoDeContrato {

	@Override
	public List<ParcelaVO> calcularParcelas(ContratoVO contratoVO) {

		ParcelaVO parcela = new ParcelaVO();

		List<ParcelaVO> parcelasVO = new ArrayList<ParcelaVO>();

		BigDecimal desconto = contratoVO.getValorCurso().multiply(BigDecimal.valueOf(contratoVO.getDescontoCurso()));

		BigDecimal cursoComDesconto = contratoVO.getValorCurso().subtract(desconto);

		BigDecimal cursoComDescontoParcelado = cursoComDesconto
				.divide(BigDecimal.valueOf(contratoVO.getQtdParcelasCurso()), 2, BigDecimal.ROUND_DOWN);

		BigDecimal residualDaParcelaCurso = cursoComDesconto
				.subtract(cursoComDescontoParcelado.multiply(BigDecimal.valueOf(contratoVO.getQtdParcelasCurso())));

		parcela.setDataVencimento(Calendar.getInstance());

		Calendar proximoVencimento = Calendar.getInstance();

		// material avista

		// primeira parcela

		// primeira cobrança do curso

		// apenas uma cobrança de material pois foi avista

		parcela.setDataVencimento(Calendar.getInstance());

		parcela.setValorParcelaCurso(cursoComDescontoParcelado);

		// unica parcela pois foi avista
		parcela.setValorParcelaMaterial(contratoVO.getValorMaterial());

		parcela.setValorTotalParcela(
				cursoComDescontoParcelado.add(contratoVO.getTaxaMatricula()).add(parcela.getValorParcelaMaterial()));

		parcela.setValorPago(parcela.getValorTotalParcela());

		parcela.setDataPagamento(Calendar.getInstance());

		parcela.setSituacaoParcela(SituacaoParcela.PAGO);

		parcelasVO.add(parcela);

		for (int i = 2; i <= contratoVO.getQtdParcelasCurso(); i++) {

			parcela = new ParcelaVO();
			// segunda parcela

			// segunda parcela do curso

			// nenhuma cobrança de material pois foi avista

			proximoVencimento = Calendar.getInstance();

			proximoVencimento.set(Calendar.DAY_OF_MONTH, contratoVO.getDiaVencimento());

			proximoVencimento.add(Calendar.MONTH, i - 1);

			parcela.setDataVencimento(proximoVencimento);

			parcela.setValorParcelaCurso(cursoComDescontoParcelado);

			parcela.setValorParcelaMaterial(BigDecimal.valueOf(0));

			// ultima parcela do curo
			if (i == contratoVO.getQtdParcelasCurso()) {
				parcela.setValorParcelaCurso(cursoComDescontoParcelado.add(residualDaParcelaCurso));
			}

			parcela.setValorTotalParcela(parcela.getValorParcelaCurso());

			parcela.setValorPago(BigDecimal.valueOf(0));

			parcela.setDataPagamento(null);

			parcela.setSituacaoParcela(SituacaoParcela.A_VENCER);

			parcelasVO.add(parcela);
		}
		return parcelasVO;
	}

}
