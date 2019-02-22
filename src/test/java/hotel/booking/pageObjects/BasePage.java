package hotel.booking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected String pageTitle;
	protected String URL;

	public static final int DEFAULT_WAIT_FOR_ELEMENT = 7;

	public BasePage(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public static WebElement waitForElement(WebDriver driver, final By by) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
