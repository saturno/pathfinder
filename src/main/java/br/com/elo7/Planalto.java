package br.com.elo7;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Planalto {

	private List<Sonda> sondas = new ArrayList<Sonda>();

	private final Coordenada coordenadaSuperiorDireita;

	public Planalto(Coordenada coordenadaSuperiorDireita) {
		super();
		this.coordenadaSuperiorDireita = coordenadaSuperiorDireita;
	}

	public void addSonda(Sonda sonda) throws LimitePlanaltoException {
		// TODO valida colisões com outras sondas?
		if (!validaCoordenada(sonda.getPosicaoVetorial().getCoordenada())) {
			throw new LimitePlanaltoException(
					"Tentativa de colocar sonda fora da área do planalto!");
		}
		this.sondas.add(sonda);
	}

	public List<Sonda> getSondas() {
		return this.sondas;
	}

	public Coordenada getCoordenadaSuperiorDireita() {
		return coordenadaSuperiorDireita;
	}

	public boolean validaCoordenada(Coordenada coordenada) {
		return coordenada.getX() >= 0 && coordenada.getY() >= 0
				&& coordenada.getX() <= getCoordenadaSuperiorDireita().getX()
				&& coordenada.getY() <= getCoordenadaSuperiorDireita().getY();
	}

	public String listaPosicaoVetorialSondas() {
		String posicaoVetorialSondas = "";
		Iterator<Sonda> iterator = getSondas().iterator();
		while (iterator.hasNext()) {
			posicaoVetorialSondas += iterator.next().getPosicaoVetorial()
					.toString();
			if (iterator.hasNext()) {
				posicaoVetorialSondas += System.getProperty("line.separator");
			}
		}
		return posicaoVetorialSondas;
	}
}
