package hotel.booking.testcases;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(features={"src/test/resources"},glue={"hotel.booking.stepdefs"}, strict=true, format = {"html:cucumber-html-reports", "json:cucumber-reports-with-handlebars/cucumber-report.json"})
public class RunTest {
	

}





