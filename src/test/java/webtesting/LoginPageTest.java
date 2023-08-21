package webtesting;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginPageTest<driver> {
  static WebDriver driver = null;

  /**
   * reuseable login
   * @param driver
   * @throws InterruptedException
   */
  public void go_to_login(WebDriver driver) throws InterruptedException {
    Thread.sleep(2000);
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
    driver.findElement(By.xpath("//nav/ul/li/a[contains(text(),'Login')]")).click();
  }

  public void validLogin(WebDriver driver) throws InterruptedException {
    String username = driver.findElement(By.xpath("//input[contains(@aria-describedby,'demo_username_label')]")).getAttribute("value");
    String password = driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']")).getAttribute("value");
    Thread.sleep(2000);

    driver.findElement(By.xpath("//input[@id = 'txt-username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id = 'txt-password']")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@id = 'btn-login']")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    String getActualText = driver.findElement(By.xpath("//div/h2")).getText();
    String expectedText = "Make Appointment";

    Assert.assertEquals(getActualText, expectedText);

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

  /**
   * Go to homepage and click login page
   */
  @Before
  public void go_to_login() throws InterruptedException {
    Thread.sleep(2000);
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
    driver.findElement(By.xpath("//nav/ul/li/a[contains(text(),'Login')]")).click();
  }

  @Test
  public void TC_01() throws InterruptedException {
    String username = "GarinTest";
    String password = driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']")).getAttribute("value");
    Thread.sleep(2000);

    driver.findElement(By.xpath("//input[@id = 'txt-username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id = 'txt-password']")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@id = 'btn-login']")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    String actualText = driver.findElement(By.xpath("//div/p[@class='lead text-danger']")).getText();
    String expectedText = "Login failed! Please ensure the username and password are valid.";

    Assert.assertEquals(actualText, expectedText);

  }

  @Test
  public void TC_02() throws InterruptedException {
    String username = driver.findElement(By.xpath("//input[contains(@aria-describedby,'demo_username_label')]")).getAttribute("value");
    String password = "passwordGarin";
    Thread.sleep(2000);

    driver.findElement(By.xpath("//input[@id = 'txt-username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id = 'txt-password']")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@id = 'btn-login']")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    String actualText = driver.findElement(By.xpath("//div/p[@class='lead text-danger']")).getText();
    String expectedText = "Login failed! Please ensure the username and password are valid.";

    Assert.assertEquals(actualText, expectedText);
  }

  @Test
  public void TC_03() throws InterruptedException {
    String username = "GarinTest";
    String password = "passwordGarin";
    Thread.sleep(2000);

    driver.findElement(By.xpath("//input[@id = 'txt-username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id = 'txt-password']")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@id = 'btn-login']")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    String actualText = driver.findElement(By.xpath("//div/p[@class='lead text-danger']")).getText();
    String expectedText = "Login failed! Please ensure the username and password are valid.";

    Assert.assertEquals(actualText, expectedText);
  }

  @Test
  public void TC_04() throws InterruptedException {
    String username = driver.findElement(By.xpath("//input[contains(@aria-describedby,'demo_username_label')]")).getAttribute("value");
    String password = driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']")).getAttribute("value");
    Thread.sleep(2000);

    driver.findElement(By.xpath("//input[@id = 'txt-username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id = 'txt-password']")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@id = 'btn-login']")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    String getActualText = driver.findElement(By.xpath("//div/h2")).getText();
    String expectedText = "Make Appointment";

    Assert.assertEquals(getActualText, expectedText);

  }

  //@DataProvider(name = "data-login")
  public Object[][] dataLogin(){
    return new Object[][]{
            {"GarinTestData", "ThisIsNotAPassword", "Failed"},
            {"John Doe", "GarinPasswordData", "Failed"},
            {"GarinTestData", "GarinPasswordData", "Failed"},
            {"John Doe", "ThisIsNotAPassword", "Success"}
    };
  }

  //@Test(dataProvider = "data-login")
  public void TC_05(String username, String password, String result) throws InterruptedException {
    driver.findElement(By.xpath("//input[@id = 'txt-username']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id = 'txt-password']")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@id = 'btn-login']")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    if(result.equals("Success")){
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
      String getActualText = driver.findElement(By.xpath("//div/h2")).getText();
      String expectedText = "Make Appointment";

      Assert.assertEquals(getActualText, expectedText);
    }else{
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
      String actualText = driver.findElement(By.xpath("//div/p[@class='lead text-danger']")).getText();
      String expectedText = "Login failed! Please ensure the username and password are valid.";

      Assert.assertEquals(actualText, expectedText);
    }

  }

  /**
   * Check user already login or not
   * if user already login, click logout btn
   */
  @After
  public void go_to_logout() throws InterruptedException {
    Thread.sleep(1000);

    driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
    boolean btnLogout = driver.findElements(By.xpath("//nav/ul/li/a[contains(text(),'Logout')]")).isEmpty();

    if(!btnLogout){
      driver.findElement(By.xpath("//nav/ul/li/a[contains(text(),'Logout')]")).click();
    }
  }

  @AfterClass
  public  static void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
  }
}