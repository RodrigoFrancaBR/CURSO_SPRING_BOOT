package br.com.franca.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.franca.domain.enun.SituacaoParcela;
import br.com.franca.domain.vo.ContratoVO;
import br.com.franca.domain.vo.ParcelaVO;

public class CursoMaterialAvista extends CondicaoDeContrato {

	@Override
	public List<ParcelaVO> calcularParcelas(ContratoVO contratoVO) {

		ParcelaVO parcelaVO = new ParcelaVO();

		List<ParcelaVO> parcelaVOs = new ArrayList<ParcelaVO>();

		parcelaVO.setDataVencimento(Calendar.getInstance());

		BigDecimal desconto = contratoVO.getValorCurso().multiply(BigDecimal.valueOf(contratoVO.getDescontoCurso()));

		parcelaVO.setValorParcelaCurso(contratoVO.getValorCurso().subtract(desconto));

		parcelaVO.setValorResidualParcelaCurso(BigDecimal.valueOf(0));

		parcelaVO.setValorParcelaMaterial(contratoVO.getValorMaterial());

		parcelaVO.setValorResidualParcelaMaterial(BigDecimal.valueOf(0));

		parcelaVO.setValorTotalParcela(parcelaVO.getValorParcelaCurso().add(parcelaVO.getValorParcelaMaterial())
				.add(contratoVO.getTaxaMatricula()));

		parcelaVO.setValorPago(parcelaVO.getValorTotalParcela());

		parcelaVO.setDataPagamento(Calendar.getInstance());

		parcelaVO.setSituacaoParcela(SituacaoParcela.PAGO);

		parcelaVO.setContratoVO(contratoVO);

		parcelaVOs.add(parcelaVO);
		return parcelaVOs;
	}
}
