package br.com.elo7;

public class Sonda {

	private PosicaoVetorial posicao;

	private final Planalto planalto;

	public Sonda(Planalto planalto, PosicaoVetorial posicao) throws LimitePlanaltoException {
		super();
		this.planalto = planalto;
		this.posicao = posicao;
		planalto.addSonda(this);
	}

	public PosicaoVetorial getPosicao() {
		return this.posicao;
	}

	public void viraDireita() {
		this.getPosicao().setDirecao(this.getPosicao().getDirecao().direita());
	}

	public void viraEsquerda() {
		this.getPosicao().setDirecao(this.getPosicao().getDirecao().esquerda());
	}

	public void anda() throws LimitePlanaltoException {
		Coordenada novaCoordenada = new Coordenada(this.getPosicao()
				.getCoordenada().getX()
				+ this.getPosicao().getDirecao().getAndaX(), this.getPosicao()
				.getCoordenada().getY()
				+ this.getPosicao().getDirecao().getAndaY());

		if (!planalto.validaCoordenada(novaCoordenada)) {
			throw new LimitePlanaltoException();
		}

		this.getPosicao().setCoordenada(novaCoordenada);
	}

}
