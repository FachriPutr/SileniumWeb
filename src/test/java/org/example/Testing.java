package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testing {


	@Test
	public void register () {
		WebDriver browser;
		//Firefox's geckodriver *requires* you to specify its location.
		System.setProperty("webdriver.chrome.driver", "/Users/macocean/Documents/Testingsilenium/chromedriver/chromedriver-116.0.5845.96");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		browser = new ChromeDriver(chromeOptions);
		browser.get("https://courses.ultimateqa.com/users/sign_up");
		browser.findElement(By.xpath("//*[@id=\"create-account\"]/h2")).isDisplayed();
		browser.close();
	}
}
