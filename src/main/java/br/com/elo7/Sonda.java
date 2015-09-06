package br.com.elo7;

public class Sonda {

	private PosicaoVetorial posicaoVetorial;

	private final Planalto planalto;

	public Sonda(Planalto planalto, PosicaoVetorial posicao)
			throws LimitePlanaltoException {
		super();
		this.planalto = planalto;
		this.posicaoVetorial = posicao;
		planalto.addSonda(this);
	}

	public PosicaoVetorial getPosicaoVetorial() {
		return this.posicaoVetorial;
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

		if (!planalto.validaCoordenada(novaCoordenada)) {
			throw new LimitePlanaltoException(
					"Sonda tentou sair da área do planalto!");
		}

		this.getPosicaoVetorial().setCoordenada(novaCoordenada);
	}

}
