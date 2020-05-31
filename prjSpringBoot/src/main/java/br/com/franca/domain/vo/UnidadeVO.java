package br.com.franca.domain.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.franca.domain.enun.Status;

@JsonPropertyOrder({ "nome", "Endereço", "status", "id" })
public class UnidadeVO implements Serializable {

	public UnidadeVO() {
	}

	public UnidadeVO(Long id, String nome, String endereco, Status status) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.status = status;
	}

	private static final long serialVersionUID = 8049902758244051937L;
	
	@JsonIgnore
	private Long id;

	private String nome;

	@JsonProperty("Endereço")
	private String endereco;

	private Status status;

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
		UnidadeVO other = (UnidadeVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UnidadeVO [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", status=" + status + "]";
	}

}
