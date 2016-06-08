package user_registration;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class name {
	WebDriver driver;
	String name = "yogesh1";
  @Test
  public void f() {
	  driver.findElement(By.id("name")).sendKeys(name);
	  driver.findElement(By.id("btn_verify")).click();
	  String patternToMatch = "[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+";
	  Pattern p = Pattern.compile(patternToMatch);
	  Matcher m = p.matcher(name);
	  boolean characterFound = m.find();
	  if(name.matches(".*\\d.*")||characterFound){
		  System.out.println("Wrong name");
		}
	  else{
			System.out.println("ok");
		   
		}
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)/Mozilla Firefox/firefox.exe");
      driver = new FirefoxDriver();
      driver.get("http://talentrack.in/register");
      driver.manage().window().maximize();
      String title = driver.getTitle();
      System.out.println("Page title is : " + title);
  }

  @AfterTest
  public void afterTest() {
  }

}
