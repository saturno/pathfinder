package br.com.elo7;

public class ComandoException extends Exception {

	private static final long serialVersionUID = 325429780575691642L;

	public ComandoException(String mensagem) {
		super(mensagem);
	}
}
