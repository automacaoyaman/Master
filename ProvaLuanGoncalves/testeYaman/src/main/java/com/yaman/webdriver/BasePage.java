package com.yaman.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	public WebDriver driver;

	public static final int WAIT_TIMEOUT = 15;

	public BasePage(WebDriver webdriver, String hostUrl) {
		this.driver = webdriver;
	}

	public BasePage(WebDriver webdriver) {
		this.driver = webdriver;
	}

	protected void typeInputs(WebElement element, String valor) {
		element.clear();
		element.sendKeys(valor);
	}

	protected WebElement waitVisible(WebElement byElement) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
		return wait.until(ExpectedConditions.visibilityOf(byElement));

	}

}