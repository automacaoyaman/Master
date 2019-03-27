package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yaman.webdriver.SrBasePage;

public class CadastroConta extends SrBasePage{

	private final static String NAME = "CadastroConta";

	public CadastroConta(WebDriver driver) {
		super(driver, NAME);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "nome")
	WebElement txtNome;
	
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement btnSalvar;
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	WebElement msgSucess;
	
	public String getMsgSucess() {
		return msgSucess.getText();
	}
	
	
	public final CadastroConta adicionarConta( String nome) throws Throwable {
		
		waitVisible(txtNome);
		typeInputs(txtNome, nome);
		btnSalvar.click();	
		
		return this;
	}

}
