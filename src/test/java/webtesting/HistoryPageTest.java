package webtesting;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Map;

public class HistoryPageTest {
  WebDriver driver = null;

  @BeforeClass
  public void setup(){
    // setting browsers path
    System.setProperty("webdriver.chrome.driver","D:/Garin/Learning/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

  }

  /**
   * Go to homepage and click login page
   */
  @BeforeMethod
  public void login() throws InterruptedException {

    LoginPageTest loginPageTest = new LoginPageTest();
    loginPageTest.go_to_login(driver);
    loginPageTest.validLogin(driver);
  }

  public Map<String, String> getActualTest(WebDriver driver) throws InterruptedException {
    AppointmentPageTest appointmentPageTest = new AppointmentPageTest();
    Map<String, String> resultData = appointmentPageTest.setAppointment(driver);
    System.out.println(resultData);

    Thread.sleep(1000);

    driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
    driver.findElement(By.xpath("//nav/ul/li/a[contains(text(),'History')]")).click();
    return resultData;
  }

  @Test
  public void TC_01() throws InterruptedException {
    String expectedPermission = null;

    Map<String, String> resultData = getActualTest(driver);

    WebElement txtTitle = driver.findElement(By.xpath("//div/h2"));
    WebElement visitDate = driver.findElement(By.xpath("//div[@class='panel-heading']"));
    WebElement facility = driver.findElement(By.id("facility"));
    WebElement hospitalReadmission = driver.findElement(By.id("hospital_readmission"));
    WebElement program = driver.findElement(By.id("program"));
    WebElement comment = driver.findElement(By.id("comment"));
    Thread.sleep(1000);

    String actualTitle = txtTitle.getText();
    String actualFacility = facility.getText();
    String actualHospitalReadmission = hospitalReadmission.getText();
    String actualProgram = program.getText();
    String actualVisitDate = visitDate.getText();
    String actualComment = comment.getText();
    Thread.sleep(1000);

    String expectedTitle = "History";

    if(resultData.get("readPermission").equals("true")){
      expectedPermission = "Yes";
    }else{
      expectedPermission = "No";
    }
    System.out.println(resultData.get("readPermission"));
//
    Assert.assertEquals(actualTitle, expectedTitle);
    Assert.assertEquals(actualFacility, resultData.get("facility"));
    Assert.assertEquals(actualHospitalReadmission, expectedPermission);
    Assert.assertEquals(actualProgram, resultData.get("program"));
    Assert.assertEquals(actualVisitDate, resultData.get("date"));
    Assert.assertEquals(actualComment, resultData.get("comment"));

  }

  @AfterClass
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
  }

}
