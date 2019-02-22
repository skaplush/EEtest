package hotel.booking.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {

	public static boolean validatePageUrl(WebDriver driver, String expectedUrl) {
		boolean result = false;
		if (driver.getCurrentUrl().equalsIgnoreCase(expectedUrl))
			result = true;
		return result;

	}

	public static boolean validateElementExistByXpath(WebDriver driver, String xpath) {
		boolean result = false;
		if (driver.findElement(By.xpath(xpath)) != null)
			result = true;
		return result;
	}

	public static boolean validateElementExistById(WebDriver driver, String id) {
		boolean result = false;
		if (driver.findElement(By.id(id)) != null)
			result = true;
		return result;
	}

}
