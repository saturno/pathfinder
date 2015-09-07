package br.com.elo7;

import org.springframework.stereotype.Component;

import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;
import br.com.elo7.transfer.InstrucoesVO;
import br.com.elo7.transfer.SondaVO;

@Component
public class NavegadorBusiness {

	public NavegadorBusiness() {
		super();
	}

	public String navega(InstrucoesVO instrucoes) throws TraducaoException,
			LimitePlanaltoException {
		Planalto planalto = instrucoes.getPlanaltoVO().adapta();
		for (SondaVO sondaVO : instrucoes.getSondasVO()) {
			Sonda sonda = sondaVO.adapta();
			planalto.addSonda(sonda);
			sonda.setPlanalto(planalto);
			sonda.navegaPelaRota();
		}
		return planalto.listaPosicaoVetorialSondas();
	}

}
