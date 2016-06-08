package TalentDashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import user_registration.Constants;

public class invoke_browser {
	WebDriver driver;
	public void call_browser(){
		driver = new FirefoxDriver();
		driver.get(Constants.WEBSITE_URL);
	}
	

}
