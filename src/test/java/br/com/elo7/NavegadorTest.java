package br.com.elo7;

import static org.junit.Assert.assertEquals;
import static br.com.elo7.DirecoesEnum.*;

import org.junit.Test;

public class NavegadorTest {

	@Test
	public void navega() {
		String instrucoes = "LMLMLMLMM";
		Planalto planalto = new Planalto(10, 10);
		Sonda sonda = new Sonda(planalto, new Posicao(1, 1, NORTE));

		Navegador navegador = new Navegador(sonda);
		navegador.navega(instrucoes);
		assertEquals(new Posicao(1, 2, NORTE), navegador.getSonda()
				.getPosicao());

	}

}
