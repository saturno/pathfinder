package br.com.elo7;

import java.util.StringTokenizer;

public class Navegador {

	public Navegador() {
		super();
	}

	/**
	 * Estou assumindo que qualquer erro encontrado nas instruções para o
	 * processamento
	 */
	public void navega(Sonda sonda, String instrucoesSonda)
			throws LimitePlanaltoException, TraducaoException {
		for (int i = 0; i < instrucoesSonda.length(); i++) {
			String comando = Character.toString(instrucoesSonda.charAt(i));
			switch (ComandosEnum.traduz(comando)) {
			case ESQUERDA:
				sonda.viraEsquerda();
				break;
			case DIREITA:
				sonda.viraDireita();
				break;
			case ANDA:
				sonda.anda();
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Estou assumindo que qualquer erro encontrado nas instruções para o
	 * processamento
	 * 
	 * @throws CoordenadaException
	 */
	public String navega(String instrucoes) throws LimitePlanaltoException,
			TraducaoException {
		StringTokenizer linhas = new StringTokenizer(instrucoes,
				System.getProperty("line.separator"));

		validaInstrucoes(linhas);
		Planalto planalto = new Planalto(new Coordenada(linhas.nextToken()));
		validaInstrucoes(linhas);

		while (linhas.hasMoreTokens()) {
			Sonda sonda = new Sonda(planalto, new PosicaoVetorial(
					linhas.nextToken()));
			validaInstrucoes(linhas);
			navega(sonda, linhas.nextToken());
		}

		return planalto.listaPosicaoVetorialSondas();
	}

	private void validaInstrucoes(StringTokenizer linhas)
			throws TraducaoException {
		if (!linhas.hasMoreTokens()) {
			throw new TraducaoException("Instruções incompletas!");
		}
	}

}
