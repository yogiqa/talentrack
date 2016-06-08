package user_registration;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Login {
	WebDriver driver;	
	String email_field =Constants.TALENT_USER_NAME;
	@Test (priority = 1)
	public void testcase1(){
		//Verify mandatory validation on email field
		//driver.findElement(By.id("username")).sendKeys("");
		if (email_field== null){
			System.out.println("Please enter the email address");
			driver.close();
		}
		else {
			System.out.println("Move to testcase2");
		}
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
  @Test  (priority = 2)
  public void testcase2(){
	  // Verify the email address is correct or not
	  String invalidemail = "sujan.pand2a@talentrack.in";
	  if(invalidemail != Constants.TALENT_USER_NAME){
		  driver.findElement(By.id("username")).sendKeys(Constants.TALENT_USER_NAME);
		  driver.findElement(By.id("password")).sendKeys(Constants.RECRUITER_PASSWORD);
		  driver.findElement(By.id("login")).click();
		  		  }
	  else{
		  System.out.println("Wrong password");
		  String msg = driver.findElement(By.id("userloginresult1")).getText();
		  System.out.println(" move to testcase3" +msg);
		  // Task : verify valid characters for email like - @, . etc
	  }
  	}
  @Test (priority = 3)
  public void testcase3(){
	  // Verify the current and actual password
	  String current_pwd = Constants.TALENT_PASSWORD;
	  if(current_pwd != Constants.RECRUITER_PASSWORD){
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys(Constants.TALENT_PASSWORD);
		  driver.findElement(By.id("login")).click();
	  }
	  else{
		  System.out.println("Wrong password");
	  }
  }
  @BeforeTest
  public void beforeTest() throws Exception{
	  driver = new FirefoxDriver();
	  driver.get(Constants.WEBSITE_URL);
	  driver.findElement(By.xpath(Constants.LOGIN_PATH)).click();
	    }

  @AfterTest
  public void afterTest() {
	 
  }

}
