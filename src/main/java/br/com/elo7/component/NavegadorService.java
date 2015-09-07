package br.com.elo7.component;

import org.springframework.stereotype.Component;

import br.com.elo7.LimitePlanaltoException;
import br.com.elo7.Navegador;
import br.com.elo7.TraducaoException;

@Component
public class NavegadorService implements INavegadorService {

	@Override
	public String navega(String instrucoes) throws LimitePlanaltoException,
			TraducaoException {
		Navegador navegador = new Navegador();
		return navegador.navega(instrucoes);
	}

}
