package br.com.franca.domain.vo;

import java.io.Serializable;
import java.util.Calendar;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.franca.domain.enun.Sexo;
import br.com.franca.domain.enun.SituacaoAluno;

public class AlunoVO extends RepresentationModel<AlunoVO> implements Serializable {
	private static final long serialVersionUID = 3532413982883113131L;
	@Mapping("id")
	private Long key;
	private String nome;
	private String cpf;
	private String rg;
	private String ufRg;
	private String orgaoExpedidor;
	private Sexo sexo;
	private Calendar dataNascimento = Calendar.getInstance();
	private String celular;
	private String residencial;
	private String email;
	private String cep;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String pai;
	private String mae;
	private SituacaoAluno situacaoAluno;

	public AlunoVO() {
	}

	public AlunoVO(Long key, String nome, String cpf, String rg, String ufRg, String orgaoExpedidor, Sexo sexo,
			Calendar dataNascimento, String celular, String residencial, String email, String cep, String endereco,
			String bairro, String cidade, String estado, String pai, String mae, SituacaoAluno situacaoAluno) {
		super();
		this.key = key;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.ufRg = ufRg;
		this.orgaoExpedidor = orgaoExpedidor;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.residencial = residencial;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pai = pai;
		this.mae = mae;
		this.situacaoAluno = situacaoAluno;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getUfRg() {
		return ufRg;
	}

	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public SituacaoAluno getSituacaoAluno() {
		return situacaoAluno;
	}

	public void setSituacaoAluno(SituacaoAluno situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
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
		AlunoVO other = (AlunoVO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlunoVO [key=" + key + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", ufRg=" + ufRg
				+ ", orgaoExpedidor=" + orgaoExpedidor + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento
				+ ", celular=" + celular + ", residencial=" + residencial + ", email=" + email + ", cep=" + cep
				+ ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", pai=" + pai + ", mae=" + mae + ", situacaoAluno=" + situacaoAluno + "]";
	}

}