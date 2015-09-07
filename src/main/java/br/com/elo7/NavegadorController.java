package br.com.elo7;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo7.component.INavegadorService;

@RestController
public class NavegadorController {

	@Autowired
	private INavegadorService navegadorService;

	// TODO POST e talvez retornar lista de sondas pro JSON
	@RequestMapping(value = "/navegacao", method = GET)
	public String navega(@RequestParam(value = "instrucoes") String instrucoes) {
		try {
			return navegadorService.navega(instrucoes);
		} catch (LimitePlanaltoException | TraducaoException e) {
			// TODO adequar
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
