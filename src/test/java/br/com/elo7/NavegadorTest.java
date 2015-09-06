package br.com.elo7;

import static org.junit.Assert.assertEquals;
import static br.com.elo7.DirecoesEnum.*;

import org.junit.Test;

public class NavegadorTest {

	@Test
	public void navega() throws LimitePlanaltoException {
		String instrucoes = "LMLMLMLMM";
		Planalto planalto = new Planalto(new Coordenada(10, 10));
		Sonda sonda = new Sonda(planalto, new PosicaoVetorial(new Coordenada(1, 1), NORTE));

		Navegador navegador = new Navegador();
		navegador.navega(sonda, instrucoes);
		assertEquals(new PosicaoVetorial(new Coordenada(1, 2), NORTE), planalto.getSondas().iterator().next()
				.getPosicao());

	}

}
