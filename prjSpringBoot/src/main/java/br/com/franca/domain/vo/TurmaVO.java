package br.com.franca.domain.vo;

import java.io.Serializable;

import br.com.franca.domain.enun.Status;

public class TurmaVO implements Serializable {

	private static final long serialVersionUID = 8425871917576134741L;

	private Long id;

	private String nome;

	private Status status;

	private UnidadeVO UnidadeVO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		TurmaVO other = (TurmaVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TurmaVO [id=" + id + ", nome=" + nome + ", status=" + status + ", UnidadeVO=" + UnidadeVO + "]";
	}

}
