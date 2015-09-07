package br.com.elo7.transfer;

import java.util.List;

public class InstrucoesVO {

	private PlanaltoVO planaltoVO;

	private List<SondaVO> sondasVO;

	public PlanaltoVO getPlanaltoVO() {
		return planaltoVO;
	}

	public void setPlanaltoVO(PlanaltoVO planaltoVO) {
		this.planaltoVO = planaltoVO;
	}

	public List<SondaVO> getSondasVO() {
		return sondasVO;
	}

	public void setSondasVO(List<SondaVO> sondasVO) {
		this.sondasVO = sondasVO;
	}

}
