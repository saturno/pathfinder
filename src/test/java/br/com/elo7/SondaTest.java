package br.com.elo7;

import static br.com.elo7.DirecoesEnum.LESTE;
import static br.com.elo7.DirecoesEnum.NORTE;
import static br.com.elo7.DirecoesEnum.SUL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;

public class SondaTest {

	@Test
	public void viraDireita() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(
				new PosicaoVetorial(new Coordenada(1, 1), NORTE), "");
		sonda.setPlanalto(new Planalto(new Coordenada(10, 10)));

		sonda.viraDireita();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), LESTE),
				sonda.getPosicaoVetorial());
		sonda.viraDireita();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), SUL),
				sonda.getPosicaoVetorial());
	}

	@Test
	public void viraEsquerda() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(new PosicaoVetorial(new Coordenada(1, 1), SUL),
				"");
		sonda.setPlanalto(new Planalto(new Coordenada(10, 10)));

		sonda.viraEsquerda();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), LESTE),
				sonda.getPosicaoVetorial());
		sonda.viraEsquerda();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 1), NORTE),
				sonda.getPosicaoVetorial());
	}

	@Test
	public void anda() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(
				new PosicaoVetorial(new Coordenada(1, 1), LESTE), "");
		sonda.setPlanalto(new Planalto(new Coordenada(10, 10)));

		sonda.anda();
		assertEquals(new PosicaoVetorial(new Coordenada(2, 1), LESTE),
				sonda.getPosicaoVetorial());
		sonda.anda();
		assertEquals(new PosicaoVetorial(new Coordenada(3, 1), LESTE),
				sonda.getPosicaoVetorial());
	}

	@Test(expected = LimitePlanaltoException.class)
	public void andaPraForaDoPlanalto() throws LimitePlanaltoException {
		Sonda sonda = new Sonda(new PosicaoVetorial(new Coordenada(0, 0), SUL),
				"");
		sonda.setPlanalto(new Planalto(new Coordenada(10, 10)));

		sonda.anda();
	}

	@Test
	public void navega() throws LimitePlanaltoException, TraducaoException {
		Sonda sonda = new Sonda(
				new PosicaoVetorial(new Coordenada(1, 1), NORTE), "LMLMLMLMM");
		Planalto planalto = new Planalto(new Coordenada(10, 10));
		sonda.setPlanalto(planalto);

		sonda.navegaPelaRota();
		assertEquals(new PosicaoVetorial(new Coordenada(1, 2), NORTE),
				sonda.getPosicaoVetorial());

	}

}
