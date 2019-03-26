package br.com.wcclark.pages;

import static br.com.wcclark.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.wcclark.core.BasePage;

public class HomePage extends BasePage {
	
	public boolean validarBoasVindasUsuario(String usuario) {
		boolean validou = false;
		WebElement mensagem_sucesso = getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
		if (mensagem_sucesso.getText().equals("Bem vindo, " + usuario + "!")) {
			validou = true;
		}

		return validou;
	}

}
