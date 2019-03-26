package br.com.wcclark.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver = null;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			switch (Propriedades.browser) {
				case FIREFOX: 
					System.setProperty("webdriver.gecko.driver", "C:\\Projeto_Provas\\Candidatos\\ClarkEwerton\\DesafioYaman\\resources\\webdriver\\geckodriver.exe");
					driver = new FirefoxDriver(); break;
				case CHROME: 
					System.setProperty("webdriver.chrome.driver", "C:\\Projeto_Provas\\Candidatos\\ClarkEwerton\\DesafioYaman\\resources\\webdriver\\chromedriver.exe");
					driver = new ChromeDriver(); break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));			
		}
		return driver;
	}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}


}
