package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.yaman.config.ConfigUtils;
import com.yaman.webdriver.SrBasePage;

public class HostPage extends SrBasePage {

	private final static String NAME = "HOSTPAGE";

	public HostPage(WebDriver driver) {
		super(driver, NAME);
		PageFactory.initElements(driver, this);
	}

	public final Login loadHomeLogin() {
		driver.navigate().to(ConfigUtils.getLoginUrl());
		return new Login(driver);
	}

	public final NovoUsuario loadHomeCadastro() {
		driver.navigate().to(ConfigUtils.getCadastroUrl());
		return new NovoUsuario(driver);
	}

}
