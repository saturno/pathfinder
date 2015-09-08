package br.com.elo7;

import br.com.elo7.exception.TraducaoException;

public enum DirecoesEnum {
	NORTE("N", 0, 1, "E", "W"), SUL("S", 0, -1, "W", "E"), LESTE("E", 1, 0,
			"S", "N"), OESTE("W", -1, 0, "N", "S");

	private final String token;
	private final int andaY;
	private final int andaX;
	private final String tokenDireita;
	private final String tokenEsquerda;

	private DirecoesEnum(String token, int andaX, int andaY,
			String tokenDireita, String tokenEsquerda) {
		this.token = token;
		this.andaX = andaX;
		this.andaY = andaY;
		this.tokenDireita = tokenDireita;
		this.tokenEsquerda = tokenEsquerda;
	}

	public DirecoesEnum direita() {
		try {
			return traduz(this.tokenDireita);
		} catch (TraducaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	public DirecoesEnum esquerda() {
		try {
			return traduz(this.tokenEsquerda);
		} catch (TraducaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getToken() {
		return token;
	}

	public int getAndaY() {
		return andaY;
	}

	public int getAndaX() {
		return andaX;
	}

	public static DirecoesEnum traduz(String direcaoString)
			throws TraducaoException {
		if (direcaoString == null || direcaoString.isEmpty()) {
			throw new TraducaoException("Não é permitida a direção vazia!");
		}

		for (DirecoesEnum direcao : values()) {
			if (direcao.getToken().equalsIgnoreCase(direcaoString)) {
				return direcao;
			}
		}

		throw new TraducaoException("Direção " + direcaoString + " Inválida!");
	}

}
