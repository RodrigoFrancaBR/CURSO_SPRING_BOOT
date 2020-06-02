package br.com.franca.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.franca.domain.enun.SituacaoParcela;
import br.com.franca.domain.vo.ContratoVO;
import br.com.franca.domain.vo.ParcelaVO;

public class CursoMaterialParcelado extends CondicaoDeContrato {

	@Override
	public List<ParcelaVO> calcularParcelas(ContratoVO contrato) {
		ParcelaVO parcelaVO = new ParcelaVO();
		List<ParcelaVO> parcelasVO = new ArrayList<ParcelaVO>();

		BigDecimal desconto = contrato.getValorCurso().multiply(BigDecimal.valueOf(contrato.getDescontoCurso()));

		BigDecimal cursoComDesconto = contrato.getValorCurso().subtract(desconto);

		BigDecimal cursoComDescontoParcelado = cursoComDesconto
				.divide(BigDecimal.valueOf(contrato.getQtdParcelasCurso()), 2, BigDecimal.ROUND_DOWN);

		BigDecimal residualDaParcelaCurso = cursoComDesconto
				.subtract(cursoComDescontoParcelado.multiply(BigDecimal.valueOf(contrato.getQtdParcelasCurso())));

		BigDecimal parcelaDoMaterial = contrato.getValorMaterial()
				.divide(BigDecimal.valueOf(contrato.getQtdParcelasMaterial()), 2, BigDecimal.ROUND_DOWN);

		BigDecimal residualDaParcelaMaterial = contrato.getValorMaterial()
				.subtract(parcelaDoMaterial.multiply(BigDecimal.valueOf(contrato.getQtdParcelasMaterial())));

		parcelaVO.setDataVencimento(Calendar.getInstance());

		Calendar proximoVencimento = Calendar.getInstance();

		// parcela.setNumeroDaParcela(1);

		// primeira cobrança do curso

		// sem cobrança de material na primeira parcela

		// sem residuo na primeira parcela

		// sem cobrança de material na primeira parcela
		parcelaVO.setValorParcelaMaterial(BigDecimal.valueOf(0));

		// sem residuo na primeira parcela

		parcelaVO.setValorParcelaCurso(cursoComDescontoParcelado.add(contrato.getTaxaMatricula()));

		parcelaVO.setValorTotalParcela(parcelaVO.getValorParcelaCurso());

		parcelaVO.setValorPago(parcelaVO.getValorTotalParcela());

		parcelaVO.setDataPagamento(Calendar.getInstance());

		parcelaVO.setSituacaoParcela(SituacaoParcela.PAGO);

		// primeira parcela paga no ato
		parcelaVO.setDataVencimento(Calendar.getInstance());

		parcelasVO.add(parcelaVO);

		int diferenca = Math.abs(contrato.getDiaVencimento() - Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

		if (diferenca >= 20)
			proximoVencimento.add(Calendar.MONTH, 1);

		for (int i = 2; (i <= contrato.getQtdParcelasCurso() || i <= contrato.getQtdParcelasMaterial() + 1); i++) {

			parcelaVO = new ParcelaVO();
			// segunda parcela

			proximoVencimento = Calendar.getInstance();

			proximoVencimento.set(Calendar.DAY_OF_MONTH, contrato.getDiaVencimento());

			proximoVencimento.add(Calendar.MONTH, i - 1);

			parcelaVO.setDataVencimento(proximoVencimento);

			// garante que inicie com zero
			parcelaVO.setValorParcelaCurso(BigDecimal.valueOf(0));
			parcelaVO.setValorParcelaMaterial(BigDecimal.valueOf(0));
			// sem taxa de matricula

			// verifico se tem parcelas de curso
			if (i <= contrato.getQtdParcelasCurso()) {

				// verificar se eh a ultima parcela do curso
				if (i == contrato.getQtdParcelasCurso()) {
					// valor da parcela com o residual na ultima parcela
					parcelaVO.setValorParcelaCurso(cursoComDescontoParcelado.add(residualDaParcelaCurso));
				} else {
					// segunda parcela do curso
					parcelaVO.setValorParcelaCurso(cursoComDescontoParcelado);
				}

			}

			// verifico se tem parcelas de Material
			if (i <= contrato.getQtdParcelasMaterial() + 1) {

				// verifico se eh a ultima do material
				if (i == contrato.getQtdParcelasMaterial() + 1) {

					// valor da parcela com o residual na ultima parcela
					parcelaVO.setValorParcelaMaterial(parcelaDoMaterial.add(residualDaParcelaMaterial));
				} else {
					// pois a primeira parcela nunca entra a parcela do material
					// apenas a do curso
					parcelaVO.setValorParcelaMaterial(parcelaDoMaterial);
				}

			}

			parcelaVO.setValorTotalParcela(parcelaVO.getValorParcelaCurso().add(parcelaVO.getValorParcelaMaterial()));

			parcelaVO.setValorPago(BigDecimal.valueOf(0));

			parcelaVO.setDataPagamento(null);

			parcelaVO.setSituacaoParcela(SituacaoParcela.A_VENCER);

			parcelasVO.add(parcelaVO);
		}
		return parcelasVO;
	}

}
