package testingweb;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class RegisterPageTest {

	static WebDriver driver = null;

	/**
	 * reuseable login
	 * @param driver
	 * @throws InterruptedException
	 */
	public void register (WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.get("https://courses.ultimateqa.com/");
		driver.findElement(By.xpath("//nav/ul/li/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/aside/a")).click();

	}
	@BeforeClass
	public static void setup(){
		// setting browsers path
		System.setProperty("webdriver.chrome.driver", "/Users/macocean/Documents/Testingsilenium/chromedriver/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test
	public void TC_01() throws InterruptedException {
		Thread.sleep(2000);
		register(driver);
		String firstName = "" ;
		String lastName = "" ;
		String email = "" ;
		String password = "" ;
		String errorMsg ="This field cannot be blank";
		String errorMsgEmail ="Please enter a valid email address";
		//String errorMsgCheckBox ="Please check this box if you wish to proceed";


		driver.findElement(By.xpath("//input[@id='user[first_name]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[last_name]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[email]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[password]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[terms]']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		boolean checkErrorFirstName = driver.findElement(By.xpath("//p[@id='user[first_name]-error' and @class='form__error-msg']")).isDisplayed();
		boolean checkErrorLastName = driver.findElement(By.xpath("//p[@id='user[last_name]-error' and @class='form__error-msg']")).isDisplayed();
		boolean checkErrorEmail = driver.findElement(By.xpath("//p[@id='user[email]-error' and @class='form__error-msg']")).isDisplayed();
		boolean checkErrorPassword = driver.findElement(By.xpath("//p[@id='user[password]-error' and @class='form__error-msg']")).isDisplayed();
		//boolean checkErrorterms =driver.findElement(By.xpath("//p[@id='user[terms]-error' and @class='form__error-msg']")).isDisplayed();

		String textErrorFirstName = driver.findElement(By.xpath("//p[@id='user[first_name]-error'][@class='form__error-msg']")).getText();
		String textErrorLastName = driver.findElement(By.xpath("//p[@id='user[last_name]-error'][@class='form__error-msg']")).getText();
		String textErrorEmail = driver.findElement(By.xpath("//p[@id='user[email]-error'][@class='form__error-msg']")).getText();
		String textErrorPassword = driver.findElement(By.xpath("//p[@id='user[password]-error'][@class='form__error-msg']")).getText();
		//String textErrorterms =driver.findElement(By.xpath("//p[@id='user[terms]-error'][@class='form__error-msg']")).getText();


		if (checkErrorFirstName){
			Assert.assertEquals(textErrorFirstName,errorMsg);
		}

		if ( checkErrorLastName){
			Assert.assertEquals(textErrorLastName,errorMsg);
		}

		if (checkErrorEmail){
			Assert.assertEquals(textErrorEmail,errorMsgEmail);
		}

		if (checkErrorPassword){
			Assert.assertEquals(textErrorPassword,errorMsg);
		}

//		if (checkErrorterms){
//			Assert.assertEquals(textErrorterms,errorMsgCheckBox);
//		}

	}

	@Test
	public void TC_02() throws InterruptedException {
		Thread.sleep(2000);
		register(driver);
		String firstName = "" ;
		String lastName = "" ;
		String email = "" ;
		String password = "" ;
		String errorMsgFirstName ="First name can't be blank";
		String errorMsgLastName ="Last name can't be blank";
		String errorMsgEmail ="Email can't be blank";
		String errorMsgPassword ="Password can't be blank";
		String errorMsgCheckBox ="Terms must be accepted";


		driver.findElement(By.xpath("//input[@id='user[first_name]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[last_name]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[email]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[password]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[terms]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		boolean checkErrorFirstName = driver.findElement(By.xpath("//form/div[1]/ul/li[1]")).isDisplayed();
		boolean checkErrorLastName = driver.findElement(By.xpath("//form/div[1]/ul/li[2]")).isDisplayed();
		boolean checkErrorEmail = driver.findElement(By.xpath("//form/div[1]/ul/li[4]")).isDisplayed();
		boolean checkErrorPassword = driver.findElement(By.xpath("//form/div[1]/ul/li[5]")).isDisplayed();
		boolean checkErrorterms =driver.findElement(By.xpath("//form/div[1]/ul/li[3]")).isDisplayed();

		String textErrorFirstName = driver.findElement(By.xpath("//form/div[1]/ul/li[1]")).getText();
		String textErrorLastName = driver.findElement(By.xpath("//form/div[1]/ul/li[2]")).getText();
		String textErrorEmail = driver.findElement(By.xpath("//form/div[1]/ul/li[4]")).getText();
		String textErrorPassword = driver.findElement(By.xpath("//form/div[1]/ul/li[5]")).getText();
		String textErrorterms =driver.findElement(By.xpath("//form/div[1]/ul/li[3]")).getText();


		if (checkErrorFirstName){
			Assert.assertEquals(textErrorFirstName,errorMsgFirstName);
		}

		if ( checkErrorLastName){
			Assert.assertEquals(textErrorLastName,errorMsgLastName);
		}

		if (checkErrorEmail){
			Assert.assertEquals(textErrorEmail,errorMsgEmail);
		}

		if (checkErrorPassword){
			Assert.assertEquals(textErrorPassword,errorMsgPassword);
		}

	   if (checkErrorterms){
			Assert.assertEquals(textErrorterms,errorMsgCheckBox);
		}

	}

	@Test
	public void TC_03() throws InterruptedException, StaleElementReferenceException {
		Thread.sleep(2000);
		register(driver);
		String firstName = "Fachri";
		String lastName = "Putra";
		String email = "Fachridevi12@gmail";
		String password = "Fachri12";
		String errorMsgEmail = "Please enter a valid email address";
		String errorMsgEmail2 ="Email is invalid";


		driver.findElement(By.xpath("//input[@id='user[first_name]']")).sendKeys(firstName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[last_name]']")).sendKeys(lastName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[terms]']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		boolean checkErrorEmail = driver.findElements(By.xpath("//p[@id='user[email]-error' and @class='form__error-msg']")).size()>0;
		boolean checkErrorEmail2 = driver.findElements(By.xpath("//form/div[1]/ul/li[1]")).size()>0;




		if (checkErrorEmail) {
			String textErrorEmail = driver.findElement(By.xpath("//p[@id='user[email]-error'][@class='form__error-msg']")).getText();
			Assert.assertEquals(textErrorEmail, errorMsgEmail);
		}
		if (checkErrorEmail2) {
			String textErrorEmail2 = driver.findElement(By.xpath("//form/div[1]/ul/li[1]")).getText();
			Assert.assertEquals(textErrorEmail2, errorMsgEmail2);
		}

	}



	@Test
	public void TC_04() throws InterruptedException{
		Thread.sleep(2000);
		register(driver);
		String firstName = "Fachri";
		String lastName = "Putra";
		String email = "Fachridevi12@gmail.com";
		String password = "Fach";
		String errorMsgPassword ="Password must be at least 8 characters.";


		driver.findElement(By.xpath("//input[@id='user[first_name]']")).sendKeys(firstName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[last_name]']")).sendKeys(lastName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[terms]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		boolean checkErrorPassword = driver.findElement(By.xpath("//form/div[1]/ul/li[1]")).isDisplayed();

		String textErrorPassword = driver.findElement(By.xpath("//form/div[1]/ul/li[1]")).getText();

		if (checkErrorPassword){
			Assert.assertEquals(textErrorPassword,errorMsgPassword);
		}

	}

	@Test
	public void TC_05() throws InterruptedException, StaleElementReferenceException {
		Thread.sleep(2000);
		register(driver);
		String firstName = "Fachri";
		String lastName = "";
		String email = "Fachridevi12@gmail.com";
		String password = "Fachri12";
		String errorMsgLastName ="This field cannot be blank";
		String errorMsgLastName2 ="Last name can't be blank";


		driver.findElement(By.xpath("//input[@id='user[first_name]']")).sendKeys(firstName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[last_name]']")).sendKeys(lastName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user[terms]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		boolean checkErrorLastName = driver.findElements(By.xpath("//p[@id='user[last_name]-error' and @class='form__error-msg']")).size()>0;
		boolean checkErrorLastName2 = driver.findElements(By.xpath("//form/div[1]/ul/li[1]")).size()>0;


		if (checkErrorLastName) {
			String textErrorLastName = driver.findElement(By.xpath("//p[@id='user[last_name]-error'][@class='form__error-msg']")).getText();
			Assert.assertEquals(textErrorLastName, errorMsgLastName);
		}
		if (checkErrorLastName2) {
			String textErrorLastName2 = driver.findElement(By.xpath("//form/div[1]/ul/li[1]")).getText();
			Assert.assertEquals(textErrorLastName2, errorMsgLastName2);
		}

	}

		@Test
		public void TC_06() throws InterruptedException, StaleElementReferenceException {
			Thread.sleep(2000);
			register(driver);
			String firstName = "Fachri";
			String lastName = "Putra";
			String email = "Jiung12@gmail.com";
			String password = "Fachri12@";



			driver.findElement(By.xpath("//input[@id='user[first_name]']")).sendKeys(firstName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='user[last_name]']")).sendKeys(lastName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys(email);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='user[terms]']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

			String Text= driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/h2")).getText();
			Assert.assertEquals("Products",Text);

		}

	@AfterClass
	public  static void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
