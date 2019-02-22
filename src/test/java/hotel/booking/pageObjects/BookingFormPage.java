package hotel.booking.pageObjects;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hotel.booking.constants.CommonConstants;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookingFormPage extends BasePage {
	private final static String PAGE_TITLE = "Hotel booking form";
	private String firstBookingToBeDeletedDivId;
	private int bookingCountBeforeCreatingANewBooking = 0;

	public BookingFormPage() {
		super(PAGE_TITLE);
	}

	public void createABooking(WebDriver driver, Map<String, String> newBooking) throws InterruptedException {
		driver.findElement(By.id(CommonConstants.bookingform_firstname_txtbox)).sendKeys(newBooking.get("FirstName"));
		driver.findElement(By.id(CommonConstants.bookingform_surname_txtbox)).sendKeys(newBooking.get("LastName"));
		driver.findElement(By.id(CommonConstants.bookingform_price_txtbox)).sendKeys(newBooking.get("Price"));
		
		WebElement dropdownlist = driver.findElement(By.id(CommonConstants.bookingform_depositpaid_dropdown));
		Select depositeDropdownList = new Select(dropdownlist);
		depositeDropdownList.selectByVisibleText(newBooking.get("Deposit").toLowerCase());
		
		driver.findElement(By.id(CommonConstants.bookingform_checkin_datepicker)).click();
		driver.findElement(By.cssSelector(CommonConstants.bookingform_nextmonth_arrow)).click();
		driver.findElement(By.xpath(CommonConstants.bookingform_nextmonth_firstsat)).click();
		driver.findElement(By.id(CommonConstants.bookingform_checkout_datepicker)).click();
		driver.findElement(By.cssSelector(CommonConstants.bookingform_nextmonth_arrow)).click();
		driver.findElement(By.xpath(CommonConstants.bookingform_nextmonth_secondsat)).click();

		bookingCountBeforeCreatingANewBooking = findNumberOfExistingBookings(driver);
		System.out.println("Bookings count before the new booking " + bookingCountBeforeCreatingANewBooking);
		driver.findElement(By.xpath(CommonConstants.bookingform_save_button)).sendKeys(Keys.RETURN);

	}

	private int findNumberOfExistingBookings(WebDriver driver) {
		return driver.findElements(By.xpath(CommonConstants.bookingform_booking_div)).size() - 1;
	}

	public void assertCreateBooking(WebDriver driver, Map<String, String> newBooking) {
		driver.navigate().refresh();
		waitForElement(driver, By.xpath(CommonConstants.bookingform_delete_button));
		String bookingText = driver.findElement(By.id(CommonConstants.bookingform_existing_booking)).getText();
		assertTrue("Text not found!", bookingText.contains(newBooking.get("FirstName")));
		assertTrue("Text not found!", bookingText.contains(newBooking.get("LastName")));
		assertTrue("Text not found!", bookingText.contains(newBooking.get("Price")));
		System.out.println("Bookings count after the new booking " + findNumberOfExistingBookings(driver));
		System.out.println("Booking created sucessfully");
	}

	public void deleteFirstBooking(WebDriver driver) throws InterruptedException {
		firstBookingToBeDeletedDivId = findFirstBookingDivId(driver);
		WebElement firstDeleteButton = waitForElement(driver,By.xpath(CommonConstants.bookingform_firstdelete_button));
		assertNotNull("No Booking found ", firstDeleteButton);
		firstDeleteButton.click();
		System.out.println("Booking id deleted is " + firstBookingToBeDeletedDivId);
		driver.navigate().refresh();
	}

	public String findFirstBookingDivId(WebDriver driver) {
		WebElement firstBookingID = waitForElement(driver, By.xpath(CommonConstants.bookingform_firstbookingid));
		assertNotNull("No booking found", firstBookingID);
		return firstBookingID.getAttribute("id");
	}

	public void assertDeleteBooking(WebDriver driver) {
		waitForElement(driver, By.xpath(CommonConstants.bookingform_save_button));
		assertTrue(driver.findElements(By.id(firstBookingToBeDeletedDivId)).size() == 0);
	}

}
