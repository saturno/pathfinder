package test.java;

import static org.junit.Assert.assertEquals;
import main.java.Planalto;
import main.java.Posicao;
import main.java.Sonda;

import org.junit.Test;

public class SondaTest {

	@Test
	public void move() {
		String movimento="LMLMLMLMM";
		Sonda sonda = new Sonda(new Planalto(10,10), new Posicao(1,1,"N"));
		sonda.move(movimento);
		assertEquals(new Posicao(1,2,"N"), sonda.getPosicao());
	}

}
