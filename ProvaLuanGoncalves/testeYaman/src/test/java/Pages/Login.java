package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yaman.webdriver.SrBasePage;

public class Login extends SrBasePage {

	private final static String NAME = "Login";

	public Login(WebDriver driver) {
		super(driver, NAME);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(id = "senha")
	WebElement txtSenha;

	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement btnEntrar;

	@FindBy(xpath = "//*[@class='dropdown-toggle']")
	WebElement btnContas;

	@FindBy(xpath = "//*[@class='dropdown-menu']//*[@href='/addConta']")
	WebElement btnAdicionar;

	@FindBy(xpath = "//*[@class='alert alert-success']")
	WebElement msgSucess;

	public String getMsgSucess() {
		return msgSucess.getText();
	}

	public final Login EfetuarLogin(String email, String senha) throws Throwable {

		waitVisible(txtEmail);
		typeInputs(txtEmail, email);
		typeInputs(txtSenha, senha);
		btnEntrar.click();

		return this;
	}

	public final CadastroConta acessarAdicionarConta() throws Throwable {

		waitVisible(btnContas);
		btnContas.click();
		waitVisible(btnAdicionar);
		btnAdicionar.click();

		return new CadastroConta(driver);
	}
}
