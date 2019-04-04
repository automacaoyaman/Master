package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import config.env;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_page {

	WebDriver driver;

	public login_page(WebDriver driver) {
		this.driver = driver;
	}

	// Elementos
	private static String inp_email 			= "email";
	private static String inp_senha 			= "senha";
	private static String btn_entrar 			= "//button[@class =\"btn btn-primary\"]";
	private static String msg_sucess			= "//div[@class = \"alert alert-success\"]";
	private static String msg_error 			= "//div[@class = \"alert alert-danger\"]";
	private static String set_email_invalido	= "null@yaman.com.br";
	private static String set_senha_invalida 	= "0000000000";
	private static String txt_msg_sucess 		= "Bem vindo, Yamano 18!";
	private static String txt_msg_error 		= "Problemas com o login do usuário";
	private static String urlIncial 			= "https://srbarriga.herokuapp.com/logar";

	public void acessarUrlLogin(String url) {
		this.driver.get(url);
	}

	public void preencherEmail(String arg1) {
		this.driver.findElement(By.id(inp_email)).sendKeys(arg1);
	}

	public void preencherSenha(String arg1) {
		this.driver.findElement(By.id(inp_senha)).sendKeys(arg1);
	}

	public void preencherFormularioLogin(String email, String senha) {
		preencherEmail(email);
		preencherSenha(senha);
	}

	public void clicarEntrar() {
		this.driver.findElement(By.xpath(btn_entrar)).click();
	}

	public void validarPaginaInicial() {
		String urlAtual = this.driver.getCurrentUrl();
		assertEquals(urlIncial, urlAtual);
	}

	public void validarMensagemLoginSucesso(String arg1) {
		String textoElement = this.driver.findElement(By.xpath(msg_sucess)).getText();
		assertEquals(arg1, textoElement);
	}

	public void preencherEmailInvalido() {
		this.driver.findElement(By.id(inp_email)).sendKeys(set_email_invalido);
	}

	public void preencherSenhaInvalida() {
		this.driver.findElement(By.id(inp_senha)).sendKeys(set_senha_invalida);
	}

	public void validarMensagemLoginErro() {
		String textoElement = this.driver.findElement(By.xpath(msg_error)).getText();
		assertEquals(txt_msg_error, textoElement);
	}

	public void loginGeral() {
		
	}
}