package br.com.elo7;

import java.util.StringTokenizer;

public class Coordenada {

	private int x;
	private int y;

	public Coordenada(int x, int y) {
		super();
		this.setX(x);
		this.setY(y);
	}

	public Coordenada(String coordenada) throws TraducaoException {
		super();
		StringTokenizer tokenCoordenada = new StringTokenizer(coordenada, " ");
		if (tokenCoordenada.countTokens() != 2) {
			throw new TraducaoException(
					"Número insuficiente de parâmetros para a Coordenada");
		}
		try {
			this.setX(Integer.valueOf(tokenCoordenada.nextToken()));
			this.setY(Integer.valueOf(tokenCoordenada.nextToken()));
		} catch (NumberFormatException e) {
			throw new TraducaoException(
					"Coordenada deve ser um número inteiro!");
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordenada other = (Coordenada) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}
