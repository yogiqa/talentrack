package TalentDashboard;

import java.util.concurrent.TimeUnit;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import user_registration.Constants;

//import user_registration.Constants;

public class talent_account {
	WebDriver driver;
	String invalidemailaddress = "sujan.panda";
	@Test (priority=1)
	public void loginpopup_title(){
		String loginpopuptitle = driver.findElement(By.xpath("//h2[@class='login-pop-head']")).getText();
		System.out.println(loginpopuptitle);
		Assert.assertTrue(loginpopuptitle.contains("login with your talentrack account56"), "Correct title");
	}
	
	@Test (priority=4)
	public void loginthrough_correctcredentials(){
		driver.findElement(By.id("username")).sendKeys(Constants.TALENT_USER_NAME);
		driver.findElement(By.id("password")).sendKeys(Constants.TALENT_PASSWORD);
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}
	@Test (priority=2)
	public void inputfield_visibilty(){
		Dimension login_popup_dimension = driver.findElement(By.id("user_login_box")).getSize();
		System.out.println(login_popup_dimension);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean usernamePresence = driver.findElement(By.id("username")).isDisplayed();
		System.out.println(usernamePresence + "input is display");
		boolean usernameEnable = driver.findElement(By.id("username")).isEnabled();
		System.out.println(usernameEnable + "input is enabled");
		Dimension input_dimension = driver.findElement(By.id("username")).getSize();
		System.out.println("Username inputbox dimensions are" + input_dimension);
	}
	@Test(priority=3)
	public void email_format(){
		driver.findElement(By.id("username")).sendKeys(invalidemailaddress);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		/*String PatternToMatch = "/b[A-Z0-9._%+-]+@[A-Z0-9.-]+/.[A-Z]{2,4}/b";
		Pattern p = Pattern.compile(PatternToMatch);
		Matcher m = p.matcher(invalidemailaddress);
		boolean characterFound = m.find();*/
		if(invalidemailaddress.matches("/b[A-Z0-9._%+-]+@[A-Z0-9.-]+/.[A-Z]{2,4}/b")){
			System.out.println("No");
		}
		else{
			System.out.println("Yes");
		}
	}
	@BeforeTest
	public void beforeTest(){
		invoke_browser browser = new invoke_browser();
		browser.call_browser();
		driver = browser.driver;
		driver.findElement(By.xpath(".//*[@id='header']/div[2]/div[2]/div[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
}
