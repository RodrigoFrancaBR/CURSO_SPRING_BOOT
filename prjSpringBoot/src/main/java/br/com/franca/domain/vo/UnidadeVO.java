package br.com.franca.domain.vo;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.franca.domain.enun.Status;

public class UnidadeVO extends RepresentationModel<UnidadeVO> implements Serializable {

	private static final long serialVersionUID = 8049902758244051937L;
	@Mapping("id")
	private Long key;
	private String nome;
	private String endereco;
	private Status status;

	public UnidadeVO() {
	}

	public UnidadeVO(Long key, String nome, String endereco, Status status) {
		this.key = key;
		this.nome = nome;
		this.endereco = endereco;
		this.status = status;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeVO other = (UnidadeVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UnidadeVO [key=" + key + ", nome=" + nome + ", endereco=" + endereco + ", status=" + status + "]";
	}

}
