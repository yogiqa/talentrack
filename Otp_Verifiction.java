package user_registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Otp_Verifiction {
    WebDriver driver;
    public void otp_verify_resend(){
        driver.findElement(By.id("phone")).sendKeys("9958833582");
        driver.findElement(By.id("btn_verify")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement otp_value = driver.findElement(By.xpath("//*[@id='verifyOTP_register']//*[@id='otp']"));
        otp_value.sendKeys(Constants.MOBILE_OTP);
        driver.findElement(By.id("resend"));
        WebElement otp_new = driver.findElement(By.xpath("//*[@id='verifyOTP_register']//*[@id='otp']"));
        otp_new.sendKeys(Constants.MOBILE_OTP);
    }
   

}	