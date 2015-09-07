package br.com.elo7.component;

import java.util.List;

import br.com.elo7.Sonda;
import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;
import br.com.elo7.transfer.InstrucoesVO;

public interface INavegadorService {

	public List<Sonda> navega(InstrucoesVO instrucoes)
			throws LimitePlanaltoException, TraducaoException;;

}
