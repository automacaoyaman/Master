package br.com.wcclark.pages;

import static br.com.wcclark.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.wcclark.core.BasePage;

public class ContaCadastroPage extends BasePage {

	public void deveEscreverCampoNomeConta(String conta) {
		escrever("nome", conta);

	}

	public boolean validarContaCadastrada() {
		boolean validou = false;
		WebElement mensagem_sucesso = getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
		if (mensagem_sucesso.getText().equals("Conta adicionada com sucesso!")) {
			validou = true;
		}

		return validou;
	}

}
