package config;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cucumber.api.java.After;

public class env {
	static WebDriver driver = null;

	public static WebDriver CreateWebDriver(String browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		System.out.println("Browser: " + browser);

		if(browser=="firefox") {
			driver = new FirefoxDriver();
			
		}else if(browser=="chrome") {
			driver = new ChromeDriver();

		}else if(browser=="internetexplorer") {
			driver = new InternetExplorerDriver();

		}else {
			System.out.println("Invalid browser name " + browser);
			System.exit(0);
		}

	driver.manage().deleteAllCookies();driver.manage().window().maximize();driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	return driver;

	}

	public static void screenShot(WebDriver driver, String nomeArquivo) {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
	
		FileUtils.copyFile(src, new File("evidencias/"+ nomeArquivo + ".png"));
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
		
	}

}
