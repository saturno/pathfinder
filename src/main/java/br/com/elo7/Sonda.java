package br.com.elo7;

import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;

public class Sonda {

	private PosicaoVetorial posicaoVetorial;

	private Planalto planalto;

	private String rota;

	public Sonda(PosicaoVetorial posicao, String rota) {
		super();
		this.posicaoVetorial = posicao;
		this.setRota(rota);
	}

	public PosicaoVetorial getPosicaoVetorial() {
		return this.posicaoVetorial;
	}

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public Planalto getPlanalto() {
		return planalto;
	}

	public void setPlanalto(Planalto planalto) {
		this.planalto = planalto;
	}

	public void viraDireita() {
		this.getPosicaoVetorial().setDirecao(
				this.getPosicaoVetorial().getDirecao().direita());
	}

	public void viraEsquerda() {
		this.getPosicaoVetorial().setDirecao(
				this.getPosicaoVetorial().getDirecao().esquerda());
	}

	public void anda() throws LimitePlanaltoException {
		Coordenada novaCoordenada = new Coordenada(this.getPosicaoVetorial()
				.getCoordenada().getX()
				+ this.getPosicaoVetorial().getDirecao().getAndaX(), this
				.getPosicaoVetorial().getCoordenada().getY()
				+ this.getPosicaoVetorial().getDirecao().getAndaY());

		if (getPlanalto() == null) {
			throw new LimitePlanaltoException(
					"A sonda não tem planalto pra andar!");
		}

		if (!getPlanalto().validaCoordenadaSonda(novaCoordenada)) {
			throw new LimitePlanaltoException(
					"Sonda tentou sair da área do planalto!");
		}

		this.getPosicaoVetorial().setCoordenada(novaCoordenada);
	}

	public void navegaPelaRota() throws LimitePlanaltoException,
			TraducaoException {
		if (getRota() == null) {
			return;
		}
		for (int i = 0; i < getRota().length(); i++) {
			String comando = Character.toString(getRota().charAt(i));
			switch (ComandosEnum.traduz(comando)) {
			case ESQUERDA:
				viraEsquerda();
				break;
			case DIREITA:
				viraDireita();
				break;
			case ANDA:
				anda();
				break;
			default:
				break;
			}
		}
	}

}
