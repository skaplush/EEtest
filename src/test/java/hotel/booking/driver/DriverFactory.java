package hotel.booking.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hotel.booking.constants.CommonConstants;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class DriverFactory {

	static public WebDriver generateDriverInstance() {
		WebDriver driver;
		if (CommonConstants.browser.equalsIgnoreCase("chrome")) {
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();

		} else if (CommonConstants.browser.equalsIgnoreCase("firefox")) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();		} 
		  else {
			  ChromeDriverManager.getInstance().setup();
			  driver = new ChromeDriver();
		}
	    driver.manage().window().maximize();
		driver.get(CommonConstants.applicationUrl);
		System.out.println("Launching the site ");
		return driver;
	}

	static public void closeDriverInstance(WebDriver driver) {
		driver.quit();
	}
}
