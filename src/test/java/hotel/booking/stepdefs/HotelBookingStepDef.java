package hotel.booking.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hotel.booking.assertions.Compare;
import hotel.booking.driver.DriverFactory;
import hotel.booking.pageObjects.BookingFormPage;

import java.io.IOException;
import java.util.Map;

public class HotelBookingStepDef {

	private BookingFormPage bookingPage;
	private WebDriver driver;
	private Map<String, String> newbooking;

	@Before
	public void beforeScenario() throws IOException {
		driver = DriverFactory.generateDriverInstance();
		System.out.println("Set-up before the scenario");
	}

	@After
	public void afterScenario() {
		DriverFactory.closeDriverInstance(driver);
		System.out.println("Clean-up after the scenario");
	}

	@Given("^the customer navigates to the hotel booking page$")
	public void the_customer_navigates_to_the_hotel_booking_page() throws Throwable {
		Compare.validatePageUrl(driver, "http://hotel-test.equalexperts.io/");
		bookingPage = new BookingFormPage();
	}

	@When("^the customer creates the booking with below details:$")
	public void the_customer_creates_the_booking_with_below_details(DataTable dateTable) throws Throwable {
		for (Map<String, String> booking : dateTable.asMaps(String.class, String.class)) {
			newbooking = booking;
			bookingPage.createABooking(driver,booking);
		}
	}

	@Then("^new booking should be displayed on the booking page$")
	public void booking_should_be_created() throws Throwable {
		bookingPage.assertCreateBooking(driver,newbooking);
	}

	@When("^the customer deletes the first booking on the page$")
	public void the_customer_deletes_the_first_booking_on_the_page() throws Throwable {
		bookingPage.deleteFirstBooking(driver);
	}

	@Then("^the first booking should not be visible on the booking page$")
	public void the_first_booking_should_not_be_visible_on_the_booking_page() throws Throwable {
		bookingPage.assertDeleteBooking(driver);

	}

}
