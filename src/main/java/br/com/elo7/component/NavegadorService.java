package br.com.elo7.component;

import org.springframework.stereotype.Component;

import br.com.elo7.NavegadorBusiness;
import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;
import br.com.elo7.transfer.InstrucoesVO;

@Component
public class NavegadorService implements INavegadorService {

	@Override
	public String navega(InstrucoesVO instrucoes)
			throws LimitePlanaltoException, TraducaoException {
		NavegadorBusiness navegador = new NavegadorBusiness();
		return navegador.navega(instrucoes);
	}

}
