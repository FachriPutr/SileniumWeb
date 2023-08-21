package webtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentPageTest {
  WebDriver driver = null;

  @BeforeClass
  public void setup(){
    // setting browsers path
    System.setProperty("webdriver.chrome.driver","D:/Garin/Learning/drivers/chromedriver-116.0.5845.96-116.0.5845.96-116.0.5845.96-116.0.5845.96.exe");
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

  public Map<String, String> setAppointment(WebDriver driver) throws InterruptedException {
    WebElement select = driver.findElement(By.id("combo_facility"));
    Select listFacility = new Select(select);

    String facilityValue = null;
    String programValue = null;

    for (int i = 0; i < listFacility.getOptions().size(); i++) {
      listFacility.selectByIndex(i);
      WebElement option = listFacility.getFirstSelectedOption();
      facilityValue = option.getText();
    }

    WebElement hospitalReadPermission = driver.findElement(By.id("chk_hospotal_readmission"));
    hospitalReadPermission.click();
    boolean readPermission = hospitalReadPermission.isSelected();

    int healthcareProgramLength = driver.findElements(By.xpath("//input[@name='programs']")).size();
    List<WebElement> healthCareProgramList = driver.findElements(By.xpath("//input[@name='programs']"));

    for (int i = 0; i < healthcareProgramLength; i++) {
      healthCareProgramList.get(i).click();
      programValue = healthCareProgramList.get(i).getAttribute("value");
    }
    Thread.sleep(500);

    String date = "20/12/2022";
    WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
    visitDate.sendKeys(date);
    Thread.sleep(500);

    WebElement txtComment = driver.findElement(By.id("txt_comment"));
    String inputComment = "Test 03";
    txtComment.sendKeys(inputComment);
    Thread.sleep(500);

    WebElement btnBook = driver.findElement(By.id("btn-book-appointment"));
    btnBook.click();

    Map<String, String> map = new HashMap<String, String>();
    map.put("facility", facilityValue);
    map.put("readPermission", String.valueOf(readPermission));
    map.put("program", programValue);
    map.put("date", date);
    map.put("comment", inputComment);
    return map;
  }

  @Test
  public void TC_01() throws InterruptedException {
    WebElement select = driver.findElement(By.id("combo_facility"));
    Select listFacility = new Select(select);

    String facilityValue = null;
    String programValue = null;

    for (int i = 0; i < listFacility.getOptions().size(); i++) {
      listFacility.selectByIndex(i);
      WebElement option = listFacility.getFirstSelectedOption();
      facilityValue = option.getText();
    }

    WebElement hospitalReadPermission = driver.findElement(By.id("chk_hospotal_readmission"));
    hospitalReadPermission.click();
    boolean readPermission = hospitalReadPermission.isSelected();

    int healthcareProgramLength = driver.findElements(By.xpath("//input[@name='programs']")).size();
    List<WebElement> healthCareProgramList = driver.findElements(By.xpath("//input[@name='programs']"));

    for (int i = 0; i < healthcareProgramLength; i++) {
      healthCareProgramList.get(i).click();
      programValue = healthCareProgramList.get(i).getAttribute("value");
    }
    Thread.sleep(500);

    String date = "20/12/2022";
    WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
    visitDate.sendKeys(date);
    Thread.sleep(500);

    WebElement txtComment = driver.findElement(By.id("txt_comment"));
    String inputComment = "Test 03";
    txtComment.sendKeys(inputComment);
    Thread.sleep(500);

    WebElement btnBook = driver.findElement(By.id("btn-book-appointment"));
    btnBook.click();

    validate(facilityValue, readPermission, programValue, date, inputComment);
  }

  public void validate(String expectedFacility, boolean readPermission, String expectedProgramValue, String expectedDate, String expectedComment) throws InterruptedException {
    Thread.sleep(1000);
    WebElement txtTitle = driver.findElement(By.xpath("//div/h2"));
    WebElement facility = driver.findElement(By.id("facility"));
    WebElement hospitalReadmission = driver.findElement(By.id("hospital_readmission"));
    WebElement program = driver.findElement(By.id("program"));
    WebElement visitDate = driver.findElement(By.id("visit_date"));
    WebElement comment = driver.findElement(By.id("comment"));
    Thread.sleep(1000);


    String actualTitle = txtTitle.getText();
    String actualFacility = facility.getText();
    String actualHospitalReadmission = hospitalReadmission.getText();
    String actualProgram = program.getText();
    String actualVisitDate = visitDate.getText();
    String actualComment = comment.getText();
    Thread.sleep(1000);

    String expectedTitle = "Appointment Confirmation";
    String expectedReadPermission = null;
    if(readPermission){
      expectedReadPermission = "Yes";
    }else{
      expectedReadPermission = "No";
    }

    Assert.assertEquals(actualTitle, expectedTitle);
    Assert.assertEquals(actualFacility, expectedFacility);
    Assert.assertEquals(actualHospitalReadmission, expectedReadPermission);
    Assert.assertEquals(actualProgram, expectedProgramValue);
    Assert.assertEquals(actualVisitDate, expectedDate);
    Assert.assertEquals(actualComment, expectedComment);
  }

  @AfterClass
  public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
  }
}
