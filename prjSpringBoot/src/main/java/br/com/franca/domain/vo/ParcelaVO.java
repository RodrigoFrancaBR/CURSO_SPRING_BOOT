package br.com.franca.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.github.dozermapper.core.Mapping;

import br.com.franca.domain.enun.SituacaoParcela;

public class ParcelaVO implements Serializable {

	private static final long serialVersionUID = -8998366616325786363L;
	@Mapping("id")
	private Long key;
	private Calendar dataVencimento = Calendar.getInstance();
	private BigDecimal valorPago;
	private Calendar dataPagamento = Calendar.getInstance();
	private BigDecimal valorParcelaCurso;
	private BigDecimal valorParcelaMaterial;
	private BigDecimal valorTotalParcela;
	private SituacaoParcela situacaoParcela;
	private BigDecimal valorResidualParcelaCurso;
	private BigDecimal valorResidualParcelaMaterial;
	private ContratoVO ContratoVO;

	public ParcelaVO() {
	}

	public ParcelaVO(Long key, Calendar dataVencimento, BigDecimal valorPago, Calendar dataPagamento,
			BigDecimal valorParcelaCurso, BigDecimal valorParcelaMaterial, BigDecimal valorTotalParcela,
			SituacaoParcela situacaoParcela, BigDecimal valorResidualParcelaCurso,
			BigDecimal valorResidualParcelaMaterial, br.com.franca.domain.vo.ContratoVO contratoVO) {
		this.key = key;
		this.dataVencimento = dataVencimento;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
		this.valorParcelaCurso = valorParcelaCurso;
		this.valorParcelaMaterial = valorParcelaMaterial;
		this.valorTotalParcela = valorTotalParcela;
		this.situacaoParcela = situacaoParcela;
		this.valorResidualParcelaCurso = valorResidualParcelaCurso;
		this.valorResidualParcelaMaterial = valorResidualParcelaMaterial;
		ContratoVO = contratoVO;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public ContratoVO getContratoVO() {
		return ContratoVO;
	}

	public void setContratoVO(ContratoVO ContratoVO) {
		this.ContratoVO = ContratoVO;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorParcelaCurso() {
		return valorParcelaCurso;
	}

	public void setValorParcelaCurso(BigDecimal valorParcelaCurso) {
		this.valorParcelaCurso = valorParcelaCurso;
	}

	public BigDecimal getValorParcelaMaterial() {
		return valorParcelaMaterial;
	}

	public void setValorParcelaMaterial(BigDecimal valorParcelaMaterial) {
		this.valorParcelaMaterial = valorParcelaMaterial;
	}

	public BigDecimal getValorTotalParcela() {
		return valorTotalParcela;
	}

	public void setValorTotalParcela(BigDecimal valorTotalParcela) {
		this.valorTotalParcela = valorTotalParcela;
	}

	public SituacaoParcela getSituacaoParcela() {
		return situacaoParcela;
	}

	public void setSituacaoParcela(SituacaoParcela situacaoParcela) {
		this.situacaoParcela = situacaoParcela;
	}

	public BigDecimal getValorResidualParcelaCurso() {
		return valorResidualParcelaCurso;
	}

	public void setValorResidualParcelaCurso(BigDecimal valorResidualParcelaCurso) {
		this.valorResidualParcelaCurso = valorResidualParcelaCurso;
	}

	public BigDecimal getValorResidualParcelaMaterial() {
		return valorResidualParcelaMaterial;
	}

	public void setValorResidualParcelaMaterial(BigDecimal valorResidualParcelaMaterial) {
		this.valorResidualParcelaMaterial = valorResidualParcelaMaterial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParcelaVO other = (ParcelaVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParcelaVO [key=" + key + ", dataVencimento=" + dataVencimento + ", valorPago=" + valorPago
				+ ", dataPagamento=" + dataPagamento + ", valorParcelaCurso=" + valorParcelaCurso
				+ ", valorParcelaMaterial=" + valorParcelaMaterial + ", valorTotalParcela=" + valorTotalParcela
				+ ", situacaoParcela=" + situacaoParcela + ", valorResidualParcelaCurso=" + valorResidualParcelaCurso
				+ ", valorResidualParcelaMaterial=" + valorResidualParcelaMaterial + ", ContratoVO=" + ContratoVO + "]";
	}

}
