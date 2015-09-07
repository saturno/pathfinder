package br.com.elo7;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;
import br.com.elo7.transfer.InstrucoesVO;
import br.com.elo7.transfer.PlanaltoVO;
import br.com.elo7.transfer.SondaVO;

public class NavegadorTest {

	@Test
	public void navegaTodasAsSondas() throws LimitePlanaltoException,
			TraducaoException {
		NavegadorBusiness navegador = new NavegadorBusiness();

		InstrucoesVO instrucoesVO = new InstrucoesVO();

		PlanaltoVO planaltoVO = new PlanaltoVO();
		planaltoVO.setX("5");
		planaltoVO.setY("5");

		instrucoesVO.setPlanaltoVO(planaltoVO);

		List<SondaVO> sondasVO = new ArrayList<SondaVO>();
		SondaVO sondaVO_1 = new SondaVO();
		sondaVO_1.setX("1");
		sondaVO_1.setY("2");
		sondaVO_1.setDirecao("N");
		sondaVO_1.setRota("LMLMLMLMM");
		sondasVO.add(sondaVO_1);
		SondaVO sondaVO_2 = new SondaVO();
		sondaVO_2.setX("3");
		sondaVO_2.setY("3");
		sondaVO_2.setDirecao("E");
		sondaVO_2.setRota("MMRMMRMRRM");
		sondasVO.add(sondaVO_2);

		instrucoesVO.setSondasVO(sondasVO);

		String retorno = navegador.navega(instrucoesVO);

		String retornoEsperado = "1 3 N" + System.getProperty("line.separator")
				+ "5 1 E";
		assertEquals(retornoEsperado, retorno);

	}

}
