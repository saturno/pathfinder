package br.com.elo7.transfer;

import java.util.List;

public class InstrucoesVO {

	private PlanaltoVO planalto;

	private List<SondaVO> sondas;

	public PlanaltoVO getPlanalto() {
		return planalto;
	}

	public void setPlanalto(PlanaltoVO planalto) {
		this.planalto = planalto;
	}

	public List<SondaVO> getSondas() {
		return sondas;
	}

	public void setSondas(List<SondaVO> sondas) {
		this.sondas = sondas;
	}

}
