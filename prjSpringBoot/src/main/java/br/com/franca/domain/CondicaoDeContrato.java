package br.com.franca.domain;

import java.util.List;

import br.com.franca.domain.vo.ContratoVO;
import br.com.franca.domain.vo.ParcelaVO;

public abstract class CondicaoDeContrato {
	public abstract List<ParcelaVO> calcularParcelas(ContratoVO contratoVO);

	public static List<ParcelaVO> getParcelas(ContratoVO contratoVO) {
		List<ParcelaVO> parcelasVO = null;

		if (contratoVO.getQtdParcelasCurso() == 1 && contratoVO.getQtdParcelasMaterial() == 1) {
			parcelasVO = new CursoMaterialAvista().calcularParcelas(contratoVO);
		}

		if (contratoVO.getQtdParcelasCurso() == 1 && contratoVO.getQtdParcelasMaterial() >= 2) {
			parcelasVO = new CursoAvistaMaterialParcelado().calcularParcelas(contratoVO);
		}

		if (contratoVO.getQtdParcelasCurso() >= 2 && contratoVO.getQtdParcelasMaterial() == 1) {
			parcelasVO = new CursoParceladoMaterialAvista().calcularParcelas(contratoVO);
		}

		if (contratoVO.getQtdParcelasCurso() >= 2 && contratoVO.getQtdParcelasMaterial() >= 2) {
			parcelasVO = new CursoMaterialParcelado().calcularParcelas(contratoVO);
		}

		return parcelasVO;
	}

}
