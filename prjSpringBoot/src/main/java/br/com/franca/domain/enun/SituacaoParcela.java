package br.com.franca.domain.enun;

import java.util.Arrays;

public enum SituacaoParcela {
	// Usado para Alunos
	A_VENCER(0, "A vencer"), PAGO(1, "Pago"), ATRASADO(2, "Atrasado"), INVALIDA(100, "Situação inválida");

	private int chave;
	private String valor;

	private SituacaoParcela(int chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	public SituacaoParcela getSituacao(int chave) {
		return Arrays.asList(SituacaoParcela.values()).parallelStream().filter(e -> e.getChave() == chave).findFirst()
				.orElse(SituacaoParcela.INVALIDA);
	}

	public int getChave() {
		return chave;
	}

	public String getValor() {
		return valor;
	}

}
