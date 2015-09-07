package br.com.elo7.transfer;

import br.com.elo7.Coordenada;
import br.com.elo7.DirecoesEnum;
import br.com.elo7.PosicaoVetorial;
import br.com.elo7.Sonda;
import br.com.elo7.exception.TraducaoException;

public class SondaVO {

	private String x;

	private String y;

	private String direcao;

	private String rota;

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

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public Sonda adapta() throws TraducaoException {
		Coordenada c = new Coordenada(Integer.valueOf(getX()),
				Integer.valueOf(getY()));
		PosicaoVetorial p = new PosicaoVetorial(c,
				DirecoesEnum.traduz(getDirecao()));
		return new Sonda(p, getRota());
	}

}
