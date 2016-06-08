package user_registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Verifypassword {
	WebDriver driver;
	public String pwd = "password";
	public String confirm_pwd = "password";
	public String wrong_pwd="yogesh";
	public Verifypassword(WebDriver driver){
		this.driver = driver;
	}
	public void passwordmatch(){
				//Password = confirm password
		driver.findElement(By.id("encrypted_pwd")).sendKeys(pwd);
		driver.findElement(By.id("confirm_pwd")).sendKeys(confirm_pwd);
		driver.findElement(By.xpath("//*[@class='submit-btn']")).click();
		if(pwd.equals(confirm_pwd)){
			System.out.println("Password Match");
		}
		else{
			System.out.println("Password doesn't Match");
		}
	}
	public void password_match1(){
		//password & confirm password <8
		driver.findElement(By.id("encrypted_pwd")).sendKeys(wrong_pwd);
		driver.findElement(By.id("confirm_pwd")).sendKeys(wrong_pwd);
		driver.findElement(By.xpath("//*[@class='submit-btn']")).click();
		String error_msg = driver.findElement(By.id("encrypted_pwd1")).getText();
		if(wrong_pwd.length() < 8){
			System.out.println(error_msg);			
		}
	}

}

