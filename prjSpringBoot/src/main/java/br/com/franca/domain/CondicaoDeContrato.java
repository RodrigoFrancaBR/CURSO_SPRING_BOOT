package br.com.franca.domain;

import java.util.List;

public abstract class CondicaoDeContrato {
	public abstract List<Parcela> calcularParcelas(Contrato contrato);

	public static List<Parcela> getParcelas(Contrato contrato) {
		List<Parcela> parcelas = null;

		if (contrato.getQtdParcelasCurso() == 1 && contrato.getQtdParcelasMaterial() == 1) {
			parcelas = new CursoMaterialAvista().calcularParcelas(contrato);
		}

		if (contrato.getQtdParcelasCurso() == 1 && contrato.getQtdParcelasMaterial() >= 2) {
			parcelas = new CursoAvistaMaterialParcelado().calcularParcelas(contrato);
		}

		if (contrato.getQtdParcelasCurso() >= 2 && contrato.getQtdParcelasMaterial() == 1) {
			parcelas = new CursoParceladoMaterialAvista().calcularParcelas(contrato);
		}

		if (contrato.getQtdParcelasCurso() >= 2 && contrato.getQtdParcelasMaterial() >= 2) {
			parcelas = new CursoMaterialParcelado().calcularParcelas(contrato);
		}

		return parcelas;
	}

}
