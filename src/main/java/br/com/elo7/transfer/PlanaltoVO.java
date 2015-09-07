package br.com.elo7.transfer;

import br.com.elo7.Coordenada;
import br.com.elo7.Planalto;

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

	public Planalto adapta() {
		Coordenada c = new Coordenada(Integer.valueOf(getX()),
				Integer.valueOf(getY()));
		return new Planalto(c);
	}

}
