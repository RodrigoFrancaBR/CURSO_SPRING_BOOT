package br.com.franca.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import br.com.franca.domain.enun.FormaPagamento;
import br.com.franca.domain.enun.SituacaoMatricula;

public class ContratoVO implements Serializable {
	private static final long serialVersionUID = -3893151623589348570L;
	private Long id;
	private BigDecimal taxaMatricula = new BigDecimal(0);
	private BigDecimal valorCurso;
	private Double descontoCurso;
	private Integer qtdParcelasCurso;
	private Integer qtdParcelasMaterial;
	private BigDecimal valorMaterial;
	private FormaPagamento formaPagamento;
	private Integer diaVencimento;
	private Calendar dataMatricula = Calendar.getInstance();
	private String matricula;
	private SituacaoMatricula SituacaoMatricula;
	private AlunoVO alunoVO;
	private TurmaVO turmaVO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTaxaMatricula() {
		return taxaMatricula;
	}

	public void setTaxaMatricula(BigDecimal taxaMatricula) {
		this.taxaMatricula = taxaMatricula;
	}

	public BigDecimal getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(BigDecimal valorCurso) {
		this.valorCurso = valorCurso;
	}

	public Double getDescontoCurso() {
		return descontoCurso;
	}

	public void setDescontoCurso(Double descontoCurso) {
		this.descontoCurso = descontoCurso;
	}

	public Integer getQtdParcelasCurso() {
		return qtdParcelasCurso;
	}

	public void setQtdParcelasCurso(Integer qtdParcelasCurso) {
		this.qtdParcelasCurso = qtdParcelasCurso;
	}

	public Integer getQtdParcelasMaterial() {
		return qtdParcelasMaterial;
	}

	public void setQtdParcelasMaterial(Integer qtdParcelasMaterial) {
		this.qtdParcelasMaterial = qtdParcelasMaterial;
	}

	public BigDecimal getValorMaterial() {
		return valorMaterial;
	}

	public void setValorMaterial(BigDecimal valorMaterial) {
		this.valorMaterial = valorMaterial;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Calendar getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Calendar dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public SituacaoMatricula getSituacaoMatricula() {
		return SituacaoMatricula;
	}

	public void setSituacaoMatricula(SituacaoMatricula situacaoMatricula) {
		SituacaoMatricula = situacaoMatricula;
	}

	public AlunoVO getAlunoVO() {
		return alunoVO;
	}

	public void setAlunoVO(AlunoVO alunoVO) {
		this.alunoVO = alunoVO;
	}

	public TurmaVO getTurmaVO() {
		return turmaVO;
	}

	public void setTurmaVO(TurmaVO turmaVO) {
		this.turmaVO = turmaVO;
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
		ContratoVO other = (ContratoVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContratoVO [id=" + id + ", taxaMatricula=" + taxaMatricula + ", valorCurso=" + valorCurso
				+ ", descontoCurso=" + descontoCurso + ", qtdParcelasCurso=" + qtdParcelasCurso
				+ ", qtdParcelasMaterial=" + qtdParcelasMaterial + ", valorMaterial=" + valorMaterial
				+ ", formaPagamento=" + formaPagamento + ", diaVencimento=" + diaVencimento + ", dataMatricula="
				+ dataMatricula + ", matricula=" + matricula + ", SituacaoMatricula=" + SituacaoMatricula + ", alunoVO="
				+ alunoVO + ", turmaVO=" + turmaVO + "]";
	}

}
