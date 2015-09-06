package br.com.elo7;

import static br.com.elo7.ComandosEnum.ANDA;
import static br.com.elo7.ComandosEnum.DIREITA;
import static br.com.elo7.ComandosEnum.ESQUERDA;

import java.util.StringTokenizer;

public class Navegador {

	public Navegador() {
		super();
	}

	public void navega(Sonda sonda, String instrucoesSonda)
			throws LimitePlanaltoException, ComandoException {
		for (int i = 0; i < instrucoesSonda.length(); i++) {
			char comando = instrucoesSonda.charAt(i);
			if (comando == ESQUERDA.getCodigo()) {
				sonda.viraEsquerda();
			} else if (comando == DIREITA.getCodigo()) {
				sonda.viraDireita();
			} else if (comando == ANDA.getCodigo()) {
				sonda.anda();
			} else {
				throw new ComandoException("Comando " + comando + " inválido! ");
			}
		}
	}

	public String navega(String instrucoes) throws LimitePlanaltoException,
			ComandoException, DirecaoException {
		// Parte feia de parsing...
		StringTokenizer linhas = new StringTokenizer(instrucoes,
				System.getProperty("line.separator"));

		Planalto planalto = extraiPlanalto(linhas.nextToken());

		while (linhas.hasMoreTokens()) {
			Sonda sonda = extraiSonda(linhas.nextToken(), planalto);
			navega(sonda, linhas.nextToken());
		}

		return planalto.listaPosicaoVetorialSondas();
	}

	private Sonda extraiSonda(String linhaSonda, Planalto planalto)
			throws LimitePlanaltoException, DirecaoException {
		StringTokenizer coordenadasSonda = new StringTokenizer(linhaSonda, " ");
		Integer coordenadaXSonda = Integer
				.valueOf(coordenadasSonda.nextToken());
		Integer coordenadaYSonda = Integer
				.valueOf(coordenadasSonda.nextToken());
		String direcao = coordenadasSonda.nextToken();
		return new Sonda(planalto, new PosicaoVetorial(new Coordenada(
				coordenadaXSonda, coordenadaYSonda),
				DirecoesEnum.traduz(direcao)));

	}

	private Planalto extraiPlanalto(String linhaPlanalto) {
		StringTokenizer coordenadasPlanalto = new StringTokenizer(
				linhaPlanalto, " ");
		Integer coordenadaXPlanalto = Integer.valueOf(coordenadasPlanalto
				.nextToken());
		Integer coordenadaYPlanalto = Integer.valueOf(coordenadasPlanalto
				.nextToken());
		return new Planalto(new Coordenada(coordenadaXPlanalto,
				coordenadaYPlanalto));
	}

}
