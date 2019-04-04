package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cadastro_page {

	WebDriver driver; 
	
	public cadastro_page(WebDriver driver) {
		this.driver = driver;
	}

	// Elementos
	private static String inp_nome      = "nome";
	private static String inp_email     = "email";
	private static String inp_senha     = "senha";
	private static String btn_cadastrar = "//*[@class='btn btn-primary']";
	private static String msg_sucess    = "//div[@class=\"alert alert-success\"]";
	private static String msg_error     = "//div[@class=\"alert alert-danger\"]";

	public void acessarUrlCadastro() {
		String url = "https://srbarriga.herokuapp.com/cadastro";
		this.driver.get(url);
	}

	public void preencherNome(String arg1) throws InterruptedException {
		this.driver.findElement(By.id(inp_nome)).sendKeys(arg1);
	}

	public void preencherEmail(String arg1) throws InterruptedException {
		this.driver.findElement(By.id(inp_email)).sendKeys(arg1);
	}

	public void preencherSenha(String arg1) throws InterruptedException {
		this.driver.findElement(By.id(inp_senha)).sendKeys(arg1);
	}
	
	public void preencherFormulario(String nome, String email, String senha) throws InterruptedException {
		preencherNome(nome);
		preencherEmail(email);
		preencherSenha(senha);
	}

	public void clicarCadastrar() throws InterruptedException {
		this.driver.findElement(By.xpath(btn_cadastrar)).click();
	}

	public void validarMensagemSucesso(String arg1) throws InterruptedException {
		String textoElement = this.driver.findElement(By.xpath(msg_sucess)).getText();
		assertEquals(arg1, textoElement);
	}

	public void validarMensagemErro(String arg1) throws InterruptedException {
		String textoElement = this.driver.findElement(By.xpath(msg_error)).getText();
		assertEquals(arg1, textoElement);
	}
}