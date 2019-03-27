package com.yaman.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.yaman.webdriver.SeleniumDriverFactory;

public class BaseTeste {

	@After
	public void tearDown() throws Exception {
		SeleniumDriverFactory.getDriver().close();
		SeleniumDriverFactory.getDriver().quit();

	}

	public byte[] getscreenshot() throws Throwable {

		File scrFile = ((TakesScreenshot) SeleniumDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		BufferedImage img = null;
		img = ImageIO.read(scrFile);
		BufferedImage dest = img;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(dest, "png", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		return imageInByte;

	}

}