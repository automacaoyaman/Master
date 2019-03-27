package com.yaman.webdriver;

import static com.yaman.config.ConfigUtils.getProperty;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDriverFactory {

	private static WebDriver driver;
	private static final String FIREFOX = "firefox";
	private static final String CHROME = "chrome";

	private SeleniumDriverFactory() {

	}

	public static WebDriver getDriver() {
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			createDriver();
		}
		return driver;
	}

	private static WebDriver createDriver() {
		String property = getProperty("driver", FIREFOX);

		if (property.equals(FIREFOX)) {
			File file = new File("C://geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (property.equals(CHROME)) {
			File file = new File("src\\test\\resources\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

}