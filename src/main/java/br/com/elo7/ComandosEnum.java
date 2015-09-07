package br.com.elo7;

public enum ComandosEnum {
	DIREITA("R"), ESQUERDA("L"), ANDA("M");

	private final String token;

	private ComandosEnum(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static ComandosEnum traduz(String comandoString)
			throws TraducaoException {
		if (comandoString == null || comandoString.isEmpty()) {
			throw new TraducaoException("Não é permitido comando vazio!");
		}

		for (ComandosEnum comando : values()) {
			if (comando.getToken().equalsIgnoreCase(comandoString)) {
				return comando;
			}
		}

		throw new TraducaoException("Comando " + comandoString + " Inválido!");
	}

}
