package user_registration;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;


public class talent_registration {
    int num = 1;
    WebDriver driver;
    WebElement delete_cookies;
    @Test (priority =1)
  public void testcase1() {
      driver.navigate().to("http://talentrack.in/register");
      String pge_title = driver.findElement(By.xpath("/html/body/section/div/div/h3")).getText();
      System.out.println("Page title is : " + pge_title);
  }
    @Test (priority =2)
  public void testcaes2(){
        Select dropdown = new Select(driver.findElement(By.cssSelector("#cat_id.req")));
        dropdown.selectByIndex(1);
        dropdown.getFirstSelectedOption().getText();
        System.out.println(dropdown);
  }
    @Test (priority =3)
  public void testcase3() throws Exception{
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String email= "test"+ timeStamp + "@test.com";
        driver.findElement(By.id("email")).sendKeys(email);
        System.out.println("Talent email address is" +email);
  }
    @Test(priority=4)
    public void testcase4(){
    	// Select talent gender
    	Select gender = new Select(driver.findElement(By.id("sex")));
    	gender.selectByVisibleText("Male");
    }
    @Test (priority=5)
    public void testcase5(){
    	// Select Date of birth
    	Select dd = new Select(driver.findElement(By.id("day_select")));
    	dd.selectByValue("12");
    	dd.getFirstSelectedOption().getText();
    	System.out.println(dd);
    	Select mm = new Select(driver.findElement(By.id("month_select")));
    	mm.selectByVisibleText("January");
    	Select yy = new Select(driver.findElement(By.id("year_select")));
    	yy.selectByValue("1988");
    }
    @Test (priority=6)
    public void testcase6() throws Exception{
    	// Enter correct mobile and correct otp
    	Verifymobileotp verify1 = new Verifymobileotp(driver);
    	verify1.verifymobilevaliddation();
    }
    @Test (priority=7)
    public void testcase7() throws Exception{
    	// Verify mobile number validation >> mobile number should not greater or less than 10 numbers.
    	Verifymobileotp verify2 = new Verifymobileotp(driver);
    	verify2.verifyotp();
    }
    @Test (priority=8)
    public void testcase8(){
    	// Select language for multi-select dropdown
    	Select select_language = new Select(driver.findElement(By.id("language[]")));
    	select_language.selectByIndex(1);
    	select_language.selectByIndex(2);
    }
    @Test  (priority=9)
    public void testcase9(){
    	Verifypassword password1 = new Verifypassword(driver);
    	password1.passwordmatch();  
    	}
    @Test (priority=10)
    	public void testcase10(){
    	// Select city from the city auto suggestion text box
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(By.id("location")).sendKeys("mum");
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('showsuggestion')//li[.='mumbai']"))).click();
    }
  @BeforeTest
  public void beforeTest() {
      System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)/Mozilla Firefox/firefox.exe");
      driver = new FirefoxDriver();
      driver.get(Constants.WEBSITE_URL);
      driver.manage().window().maximize();
      String title = driver.getTitle();
      System.out.println("Page title is : " + title);
      }

  @AfterTest
  public void afterTest() {
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  //driver.close();
       }
  public void getscreenshot() throws Exception{
      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("D://screenshot.png") );
  }
  public void otp_confirmation(){
	driver.findElement(By.id("phone")).sendKeys(Constants.MOBILE_NUMBER);
  	driver.findElement(By.id("btn_verify")).click();
  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	WebElement otp_value = driver.findElement(By.xpath("//*[@id='verifyOTP_register']//*[@id='otp']"));
  	otp_value.sendKeys(Constants.MOBILE_OTP);
     
  }
}

