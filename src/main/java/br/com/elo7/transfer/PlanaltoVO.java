package br.com.elo7.transfer;

import br.com.elo7.Coordenada;
import br.com.elo7.Planalto;
import br.com.elo7.exception.TraducaoException;

public class PlanaltoVO {

	private String x;

	private String y;

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public Planalto adapta() throws TraducaoException {
		Coordenada c;
		try {
			c = new Coordenada(Integer.valueOf(getX()), Integer.valueOf(getY()));
		} catch (NumberFormatException e) {
			throw new TraducaoException(
					"As coordenadas devem ser números inteiros!");
		}

		return new Planalto(c);
	}

}
