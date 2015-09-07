package br.com.elo7.component;

import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;
import br.com.elo7.transfer.InstrucoesVO;

public interface INavegadorService {

	public String navega(InstrucoesVO instrucoes)
			throws LimitePlanaltoException, TraducaoException;;

}
