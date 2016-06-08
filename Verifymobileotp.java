package user_registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verifymobileotp {
	WebDriver driver;
	String mobilenumber = Constants.MOBILE_NUMBER;
	String wrongmobileno = Constants.WRONG_MOBILE_NUMBER;
	public Verifymobileotp(WebDriver driver){
		this.driver=driver;
	}
	public void otpcommonaction()throws Exception{
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(Constants.MOBILE_NUMBER);
		Thread.sleep(10000);
		driver.findElement(By.id("btn_verify")).click();
		}
	public void verifyotp()throws Exception{
		otpcommonaction();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='verifyOTP_register']//*[@id='otp']")).sendKeys(Constants.MOBILE_OTP);
		driver.findElement(By.xpath("//*[@id='verifyOTP_register']//*[@type='submit']")).click();		
	}
	public void verifymobilevaliddation()throws Exception{
		driver.findElement(By.id("phone")).sendKeys(wrongmobileno);
		Thread.sleep(30000);
		if(wrongmobileno.length()!=10){
			System.out.println("Wrong mobile number");
		}
		else{
			System.out.println("mobile number is in correct value");
			
		}
		
	}
}
