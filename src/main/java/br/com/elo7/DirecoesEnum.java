package br.com.elo7;

public enum DirecoesEnum {
	NORTE(0, 1), SUL(0, -1), LESTE(1, 0), OESTE(-1, 0);

	private final int andaY;
	private final int andaX;

	private DirecoesEnum(int andaX, int andaY) {
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

	public int getAndaY() {
		return andaY;
	}

	public int getAndaX() {
		return andaX;
	}

}
