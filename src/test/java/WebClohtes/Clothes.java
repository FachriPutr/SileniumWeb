package WebClohtes;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Clothes {
	static WebDriver driver = null;

	/**
	 * reuseable login
	 * @param driver
	 * @throws InterruptedException
	 */
	public void login (WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.get("http://teststore.automationtesting.co.uk");
		//driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span")).click();
		Thread.sleep(2000);

	}
	@BeforeClass
	public static void setup(){
		// setting browsers path
		System.setProperty("webdriver.chrome.driver", "/Users/macocean/Documents/Testingsilenium/chromedriver-116.0.5845.96-116.0.5845.96-116.0.5845.96-116.0.5845.96/chromedriver-116.0.5845.96-116.0.5845.96-116.0.5845.96-116.0.5845.96");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test
	public void TC_01() throws InterruptedException, StaleElementReferenceException {
		Thread.sleep(2000);
		login(driver);
		driver.findElement(By.xpath("//*[@id=\"category-3\"]/a")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String getActualText = driver.findElement(By.xpath("//*[@id=\"js-product-list-header\"]/div/h1")).getText();
		String expectedText = "CLOTHES";

		Assert.assertEquals(getActualText, expectedText);

	}

	@Test
	public void TC_02() throws InterruptedException, StaleElementReferenceException {
		Thread.sleep(2000);
		login(driver);
		driver.findElement(By.xpath("//*[@id=\"category-3\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String getActualText = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1")).getText();
		String expectedText = "HUMMINGBIRD PRINTED T-SHIRT";

		Assert.assertEquals(getActualText, expectedText);

	}

	@Test
	public void TC_03() throws InterruptedException, StaleElementReferenceException {
		Thread.sleep(2000);
		login(driver);
		driver.findElement(By.xpath("//*[@id=\"category-3\"]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String getActualText = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1")).getText();
		String expectedText = "SHOPPING CART";

		Assert.assertEquals(getActualText, expectedText);

	}


}
