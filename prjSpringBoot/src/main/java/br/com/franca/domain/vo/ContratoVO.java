package br.com.franca.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.franca.domain.enun.FormaPagamento;
import br.com.franca.domain.enun.SituacaoMatricula;

public class ContratoVO extends RepresentationModel<ContratoVO> implements Serializable {
	
	private static final long serialVersionUID = -3893151623589348570L;
	@Mapping("id")
	private Long key;
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
	private SituacaoMatricula situacaoMatricula;
	private AlunoVO alunoVO;
	private TurmaVO turmaVO;

	public ContratoVO() {
	}

	public ContratoVO(Long key, BigDecimal taxaMatricula, BigDecimal valorCurso, Double descontoCurso,
			Integer qtdParcelasCurso, Integer qtdParcelasMaterial, BigDecimal valorMaterial,
			FormaPagamento formaPagamento, Integer diaVencimento, Calendar dataMatricula, String matricula,
			br.com.franca.domain.enun.SituacaoMatricula situacaoMatricula, AlunoVO alunoVO, TurmaVO turmaVO) {
		this.key = key;
		this.taxaMatricula = taxaMatricula;
		this.valorCurso = valorCurso;
		this.descontoCurso = descontoCurso;
		this.qtdParcelasCurso = qtdParcelasCurso;
		this.qtdParcelasMaterial = qtdParcelasMaterial;
		this.valorMaterial = valorMaterial;
		this.formaPagamento = formaPagamento;
		this.diaVencimento = diaVencimento;
		this.dataMatricula = dataMatricula;
		this.matricula = matricula;
		this.situacaoMatricula = situacaoMatricula;
		this.alunoVO = alunoVO;
		this.turmaVO = turmaVO;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
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
		return situacaoMatricula;
	}

	public void setSituacaoMatricula(SituacaoMatricula situacaoMatricula) {
		this.situacaoMatricula = situacaoMatricula;
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
		ContratoVO other = (ContratoVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContratoVO [key=" + key + ", taxaMatricula=" + taxaMatricula + ", valorCurso=" + valorCurso
				+ ", descontoCurso=" + descontoCurso + ", qtdParcelasCurso=" + qtdParcelasCurso
				+ ", qtdParcelasMaterial=" + qtdParcelasMaterial + ", valorMaterial=" + valorMaterial
				+ ", formaPagamento=" + formaPagamento + ", diaVencimento=" + diaVencimento + ", dataMatricula="
				+ dataMatricula + ", matricula=" + matricula + ", situacaoMatricula=" + situacaoMatricula + ", alunoVO="
				+ alunoVO + ", turmaVO=" + turmaVO + "]";
	}

}
