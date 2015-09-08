package br.com.elo7.exception;

public class ManipuladorExcecoes {

	private static final String ERRO = "Erro";

	private String mensagem;

	public ManipuladorExcecoes(String mensagem) {
		this.setMensagem(mensagem);
	}

	public String getStatus() {
		return ERRO;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
