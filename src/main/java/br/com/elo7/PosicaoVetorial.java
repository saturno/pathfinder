package br.com.elo7;

public class PosicaoVetorial {

	private Coordenada coordenada;
	private DirecoesEnum direcao;

	public PosicaoVetorial(Coordenada coordenada, DirecoesEnum direcao) {
		this.setCoordenada(coordenada);
		this.direcao = direcao;
	}

	public DirecoesEnum getDirecao() {
		return direcao;
	}

	public void setDirecao(DirecoesEnum direcao) {
		this.direcao = direcao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((direcao == null) ? 0 : direcao.hashCode());
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
		PosicaoVetorial other = (PosicaoVetorial) obj;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (direcao != other.direcao)
			return false;
		return true;
	}

}
