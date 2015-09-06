package br.com.elo7;

import static org.junit.Assert.assertEquals;
import static br.com.elo7.DirecoesEnum.*;

import org.junit.Test;

public class NavegadorTest {

	@Test
	public void navegaUmaSonda() throws LimitePlanaltoException,
			ComandoException {
		String instrucoes = "LMLMLMLMM";
		Planalto planalto = new Planalto(new Coordenada(10, 10));
		Sonda sonda = new Sonda(planalto, new PosicaoVetorial(new Coordenada(1,
				1), NORTE));

		Navegador navegador = new Navegador();
		navegador.navega(sonda, instrucoes);
		assertEquals(new PosicaoVetorial(new Coordenada(1, 2), NORTE), planalto
				.getSondas().iterator().next().getPosicaoVetorial());

	}

	@Test
	public void navegaTodasAsSondas() throws LimitePlanaltoException,
			ComandoException, DirecaoException {
		String instrucoes = "5 5" + System.getProperty("line.separator")
				+ "1 2 N" + System.getProperty("line.separator") + "LMLMLMLMM"
				+ System.getProperty("line.separator") + "3 3 E"
				+ System.getProperty("line.separator") + "MMRMMRMRRM";
		Navegador navegador = new Navegador();
		String retorno = navegador.navega(instrucoes);

		String retornoEsperado = "1 3 N" + System.getProperty("line.separator")
				+ "5 1 E";
		assertEquals(retornoEsperado, retorno);

	}

}
