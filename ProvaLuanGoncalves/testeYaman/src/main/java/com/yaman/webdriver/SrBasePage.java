package com.yaman.webdriver;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SrBasePage extends BasePage {

	public SrBasePage(WebDriver webdriver, String name) {
		super(webdriver);
		this.nomeTela = name;
	}

	protected String nomeTela;

	@FindBy(name = "field_1_0")
	WebElement txtToNavegate;

	public <TPage extends SrBasePage> TPage navegarPara(Class<TPage> pageClass) {
		TPage page = null;
		try {
			page = pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
			navegarParaPage(page);
			return page;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return page;
	}

	private void navegarParaPage(SrBasePage page) {
		typeInputs(txtToNavegate, page.nomeTela);
		txtToNavegate.sendKeys(Keys.ENTER);
	}

}
