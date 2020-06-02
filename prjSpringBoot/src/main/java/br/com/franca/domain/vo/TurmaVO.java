package br.com.franca.domain.vo;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.franca.domain.enun.Status;

public class TurmaVO extends RepresentationModel<UnidadeVO> implements Serializable {

	private static final long serialVersionUID = 8425871917576134741L;
	@Mapping("id")
	private Long key;
	private String nome;
	private Status status;
	private UnidadeVO UnidadeVO;

	public TurmaVO() {
	}

	public TurmaVO(Long key, String nome, Status status, UnidadeVO unidadeVO) {
		this.key = key;
		this.nome = nome;
		this.status = status;
		UnidadeVO = unidadeVO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeVO getUnidadeVO() {
		return UnidadeVO;
	}

	public void setUnidadeVO(UnidadeVO UnidadeVO) {
		this.UnidadeVO = UnidadeVO;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "TurmaVO [key=" + key + ", nome=" + nome + ", status=" + status + ", UnidadeVO=" + UnidadeVO + "]";
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
		TurmaVO other = (TurmaVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
