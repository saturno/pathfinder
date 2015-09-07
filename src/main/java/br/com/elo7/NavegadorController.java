package br.com.elo7;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo7.component.INavegadorService;
import br.com.elo7.exception.LimitePlanaltoException;
import br.com.elo7.exception.TraducaoException;
import br.com.elo7.transfer.InstrucoesVO;
import br.com.elo7.transfer.SondaVO;

@RestController
public class NavegadorController {

	@Autowired
	private INavegadorService navegadorService;

	@RequestMapping(value = "/navegacao", method = POST, headers = { "content-type=application/json" })
	public List<SondaVO> navega(@RequestBody InstrucoesVO instrucoes) {
		try {
			return SondaVO.adapta(navegadorService.navega(instrucoes));
		} catch (LimitePlanaltoException | TraducaoException e) {
			// TODO adequar
			e.printStackTrace();
			return null;
		}
	}
}
