package br.com.franca.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import br.com.franca.domain.enun.SituacaoParcela;

public class ParcelaVO implements Serializable {

	private static final long serialVersionUID = -8998366616325786363L;
	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParcelaVO [id=" + id + ", dataVencimento=" + dataVencimento + ", valorPago=" + valorPago
				+ ", dataPagamento=" + dataPagamento + ", valorParcelaCurso=" + valorParcelaCurso
				+ ", valorParcelaMaterial=" + valorParcelaMaterial + ", valorTotalParcela=" + valorTotalParcela
				+ ", situacaoParcela=" + situacaoParcela + ", valorResidualParcelaCurso=" + valorResidualParcelaCurso
				+ ", valorResidualParcelaMaterial=" + valorResidualParcelaMaterial + ", ContratoVO=" + ContratoVO + "]";
	}

}
