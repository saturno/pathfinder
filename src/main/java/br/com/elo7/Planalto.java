package br.com.elo7;

import java.util.ArrayList;
import java.util.List;

public class Planalto {

	private List<Sonda> sondas = new ArrayList<Sonda>();

	private int largura;

	private int comprimento;

	public Planalto(int comprimento, int largura) {
		this.comprimento = comprimento;
		this.largura = largura;
	}

	public void addSonda(Sonda sonda) {
		// TODO valida posição no planalto e colisões com outras sondas
		this.sondas.add(sonda);
	}

	public List<Sonda> getSondas() {
		return this.sondas;
	}
}
