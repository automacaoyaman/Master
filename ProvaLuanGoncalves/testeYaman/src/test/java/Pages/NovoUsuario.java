package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.yaman.webdriver.SrBasePage;

public class NovoUsuario extends SrBasePage {

	private final static String NAME = "CadastroConta";

	public NovoUsuario(WebDriver driver) {
		super(driver, NAME);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nome")
	WebElement txtNome;

	@FindBy(id = "email")
	WebElement txtEmail;

	@FindBy(id = "senha")
	WebElement txtSenha;

	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement btnCadastrar;

	@FindBy(xpath = "//*[@class='alert alert-success']")
	WebElement msgSucess;

	@FindBy(xpath = "//*[@class='alert alert-danger']")
	WebElement msgFail;

	public String getMsgSucess() {
		return msgSucess.getText();
	}

	public String getMsgFail() {
		return msgFail.getText();
	}

	public final NovoUsuario CadastrarUsuario(String nome, String email, String senha) throws Throwable {

		waitVisible(txtNome);
		typeInputs(txtNome, nome);
		typeInputs(txtEmail, email);
		typeInputs(txtSenha, senha);
		btnCadastrar.click();

		return this;
	}

}
