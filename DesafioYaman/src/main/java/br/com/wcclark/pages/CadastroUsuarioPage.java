package br.com.wcclark.pages;

import br.com.wcclark.core.BasePage;
import static br.com.wcclark.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CadastroUsuarioPage extends BasePage {

	public void deveEscreverCampoNome(String valor) {
		escrever("nome", valor);

	}

	public void deveEscreverCampoEmail(String valor) {
		escrever("email", valor);

	}

	public void deveEscreverCampoSenha(String valor) {
		escrever("senha", valor);

	}

	public void clicarBotaoCadastrar() {
		clicarBotaoPorTexto("Cadastrar");
	}

	public boolean validarUsuarioCadastrado() {
		boolean validou = false;
		WebElement mensagem_sucesso = getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
		if (mensagem_sucesso.getText().equals("Usuário inserido com sucesso")) {
			validou = true;
		}

		return validou;
	}

}
