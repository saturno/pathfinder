package br.com.elo7;

public enum DirecoesEnum {
	NORTE("N", 0, 1), SUL("S", 0, -1), LESTE("E", 1, 0), OESTE("W", -1, 0);

	private final int andaY;
	private final int andaX;
	private final String token;

	private DirecoesEnum(String token, int andaX, int andaY) {
		this.token = token;
		this.andaX = andaX;
		this.andaY = andaY;
	}

	public DirecoesEnum direita() {
		DirecoesEnum direita = null;
		switch (this) {
		case NORTE:
			direita = LESTE;
			break;
		case SUL:
			direita = OESTE;
			break;
		case LESTE:
			direita = SUL;
			break;
		case OESTE:
			direita = NORTE;
			break;
		default:
			break;
		}
		return direita;
	}

	public DirecoesEnum esquerda() {
		DirecoesEnum esquerda = null;
		switch (this) {
		case NORTE:
			esquerda = OESTE;
			break;
		case SUL:
			esquerda = LESTE;
			break;
		case LESTE:
			esquerda = NORTE;
			break;
		case OESTE:
			esquerda = SUL;
			break;
		default:
			esquerda = null;
			break;
		}
		return esquerda;
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
			throws DirecaoException {
		if (direcaoString == null || direcaoString.isEmpty()) {
			throw new DirecaoException("Não é permitida a direção vazia!");
		}

		for (DirecoesEnum direcao : values()) {
			if (direcao.getToken().equalsIgnoreCase(direcaoString)) {
				return direcao;
			}
		}

		throw new DirecaoException("Direção " + direcaoString + " Inválida!");
	}

}
