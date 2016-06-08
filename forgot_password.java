package user_registration;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class forgot_password {
	WebDriver driver;
  @Test
  public void forgot_pwd() throws Exception {
	  
	  driver.findElement(By.xpath(Constants.LOGIN_PATH)).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(Constants.FORGET_PATH)).click();
	  try{
	  WebElement email = driver.findElement(By.id("email"));
	  email.sendKeys(Constants.RECRUITER_USER_NAME);
	  System.out.println("Working");
	  }
	  catch (Exception e)
	  {
		  System.out.println("Not Working");
	  }
	  driver.findElement(By.xpath("html/body/div[3]/div/form/div/div[4]/span/input")).click();
	  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  Reporter.log("Browser Opened");
	  driver.get(Constants.WEBSITE_URL);
	  driver.manage().window().maximize();
	  String load = driver.manage().logs().toString();
	  System.out.println(load);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
