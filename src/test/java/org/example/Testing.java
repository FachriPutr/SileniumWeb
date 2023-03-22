package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class Testing {
	@Test
	public void site_header_is_on_home_page() {
		WebDriver browser;
		//Firefox's geckodriver *requires* you to specify its location.
		System.setProperty("webdriver.chrome.driver", "/Users/macocean/Documents/Testingsilenium/chromedriver/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		browser = new ChromeDriver(chromeOptions);
		browser.get("https://courses.ultimateqa.com/users/sign_up");
		WebElement header = browser.findElement(By.id("site-header"));
		assertTrue((header.isDisplayed()));
		browser.close();
	}
}
