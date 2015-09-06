package br.com.elo7;

public enum ComandosEnum {
	DIREITA('R'), ESQUERDA('L'), ANDA('M');

	private final char codigo;

	private ComandosEnum(char codigo) {
		this.codigo = codigo;
	}

	public char getCodigo() {
		return codigo;
	}
}
