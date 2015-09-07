package br.com.elo7.transfer;

import java.util.ArrayList;
import java.util.List;

import br.com.elo7.Coordenada;
import br.com.elo7.DirecoesEnum;
import br.com.elo7.PosicaoVetorial;
import br.com.elo7.Sonda;
import br.com.elo7.exception.TraducaoException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	@JsonIgnore
	public String getRota() {
		return rota;
	}

	@JsonProperty
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
		Coordenada c;
		try {
			c = new Coordenada(Integer.valueOf(getX()), Integer.valueOf(getY()));
		} catch (NumberFormatException e) {
			throw new TraducaoException(
					"As coordenadas devem ser números inteiros!");
		}
		PosicaoVetorial p = new PosicaoVetorial(c,
				DirecoesEnum.traduz(getDirecao()));
		return new Sonda(p, getRota());
	}

	public static SondaVO adapta(Sonda sonda) {
		SondaVO sondaVO = new SondaVO();
		sondaVO.setDirecao(sonda.getPosicaoVetorial().getDirecao().getToken());
		sondaVO.setX(String.valueOf(sonda.getPosicaoVetorial().getCoordenada()
				.getX()));
		sondaVO.setY(String.valueOf(sonda.getPosicaoVetorial().getCoordenada()
				.getY()));
		return sondaVO;
	}

	public static List<SondaVO> adapta(List<Sonda> sondas) {
		List<SondaVO> sondasVO = new ArrayList<SondaVO>();
		for (Sonda sonda : sondas) {
			sondasVO.add(adapta(sonda));
		}
		return sondasVO;
	}

}
