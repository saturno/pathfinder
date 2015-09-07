package br.com.elo7;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;
import br.com.elo7.transfer.InstrucoesVO;
import br.com.elo7.transfer.SondaVO;

@Component
public class NavegadorBusiness {

	/**
	 * Optei por mudar a entrada e saída de dados. Uma String formatada não é a
	 * melhor opção para um serviço Restful. Dessa forma, preferi o uso de vo's.
	 * Poderia também ter trabalhado diretamente com as entidades Sonda,
	 * Planalto, etc. Mas, para fins de simplificar a entrada e saída, e não ter
	 * acoplamento das entidades com as entradas e saídas, preferi adapta-las a
	 * vo's.
	 * 
	 * @param instrucoes
	 *            vo com as instruções
	 * @return Lista de Sondas com as novas posições
	 * @throws TraducaoException
	 * @throws LimitePlanaltoException
	 */
	public List<Sonda> navega(InstrucoesVO instrucoes)
			throws TraducaoException, LimitePlanaltoException {
		Planalto planalto = instrucoes.getPlanalto().adapta();
		for (SondaVO sondaVO : instrucoes.getSondas()) {
			Sonda sonda = sondaVO.adapta();
			planalto.addSonda(sonda);
			sonda.setPlanalto(planalto);
			sonda.navegaPelaRota();
		}
		return planalto.getSondas();
	}

}
