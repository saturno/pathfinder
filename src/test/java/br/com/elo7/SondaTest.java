package br.com.elo7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static br.com.elo7.DirecoesEnum.*;
import br.com.elo7.Planalto;
import br.com.elo7.Posicao;
import br.com.elo7.Sonda;

public class SondaTest {

	@Test
	public void viraDireita() {
		Sonda sonda = new Sonda(new Planalto(10, 10), new Posicao(1, 1, NORTE));
		sonda.viraDireita();
		assertEquals(new Posicao(1, 1, LESTE), sonda.getPosicao());
		sonda.viraDireita();
		assertEquals(new Posicao(1, 1, SUL), sonda.getPosicao());
	}

	@Test
	public void viraEsquerda() {
		Sonda sonda = new Sonda(new Planalto(10, 10), new Posicao(1, 1, SUL));
		sonda.viraEsquerda();
		assertEquals(new Posicao(1, 1, LESTE), sonda.getPosicao());
		sonda.viraEsquerda();
		assertEquals(new Posicao(1, 1, NORTE), sonda.getPosicao());
	}

	@Test
	public void anda() {
		Sonda sonda = new Sonda(new Planalto(10, 10), new Posicao(1, 1, LESTE));
		sonda.anda();
		assertEquals(new Posicao(2, 1, LESTE), sonda.getPosicao());
		sonda.anda();
		assertEquals(new Posicao(3, 1, LESTE), sonda.getPosicao());
	}

	@Test(expected = LimitePlanaltoException.class)
	public void andaPraForaDoPlanalto() {
		Sonda sonda = new Sonda(new Planalto(10, 10), new Posicao(0, 0, SUL));
		sonda.anda();
	}

}
