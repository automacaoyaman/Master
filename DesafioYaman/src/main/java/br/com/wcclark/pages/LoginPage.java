package br.com.wcclark.pages;

import static br.com.wcclark.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.wcclark.core.BasePage;

public class LoginPage extends BasePage {

	public void deveEscreverCampoEmail(String valor) {
		escrever("email", valor);

	}

	public void deveEscreverCampoSenha(String valor) {
		escrever("senha", valor);

	}

	public void clicarBotaoEntrar() {
		clicarBotaoPorTexto("Entrar");
	}

	public boolean validarNovoCadastrado() {
		boolean validou = false;
		WebElement mensagem_sucesso = getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
		if (mensagem_sucesso.getText().equals("Usuário inserido com sucesso")) {
			validou = true;
		}

		return validou;
	}

	public boolean validarUsuarioCadastrado() {
		boolean validou = false;
		WebElement mensagem_sucesso = getDriver().findElement(By.xpath("//div[@class='alert alert-danger']"));
		if (mensagem_sucesso.getText().equals("Endereço de e-mail já utilizado")) {
			validou = true;
		}

		return validou;
	}

}
