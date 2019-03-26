package br.com.wcclark.pages;

import br.com.wcclark.core.BasePage;

public class MenuPage extends BasePage {
	
	public void escolherOpcaoMenu(String valor) {
		clicarLink(valor);
	}

}
