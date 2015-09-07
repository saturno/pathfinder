package br.com.elo7.component;

import br.com.elo7.LimitePlanaltoException;
import br.com.elo7.TraducaoException;

public interface INavegadorService {

	public String navega(String instrucoes) throws LimitePlanaltoException,
			TraducaoException;

}
