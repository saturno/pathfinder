package br.com.elo7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static br.com.elo7.DirecoesEnum.*;
import br.com.elo7.Planalto;
import br.com.elo7.PosicaoVetorial;
import br.com.elo7.Sonda;

public class SondaTest {

	@Test
	public void viraDireita() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(new Planalto(new Coordenada(10, 10)), new PosicaoVetorial(new Coordenada(1, 1), NORTE));
		sonda.viraDireita();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), LESTE), sonda.getPosicao());
		sonda.viraDireita();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), SUL), sonda.getPosicao());
	}

	@Test
	public void viraEsquerda() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(new Planalto(new Coordenada(10, 10)), new PosicaoVetorial(new Coordenada(1, 1), SUL));
		sonda.viraEsquerda();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), LESTE), sonda.getPosicao());
		sonda.viraEsquerda();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), NORTE), sonda.getPosicao());
	}

	@Test
	public void anda() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(new Planalto(new Coordenada(10, 10)), new PosicaoVetorial(new Coordenada(1, 1), LESTE));
		sonda.anda();
		assertEquals(new PosicaoVetorial(new Coordenada(2, 1), LESTE), sonda.getPosicao());
		sonda.anda();
		assertEquals(new PosicaoVetorial(new Coordenada(3, 1), LESTE), sonda.getPosicao());
	}

	@Test(expected = LimitePlanaltoException.class)
	public void andaPraForaDoPlanalto() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(new Planalto(new Coordenada(10, 10)), new PosicaoVetorial(new Coordenada(0, 0), SUL));
		sonda.anda();
	}

}
