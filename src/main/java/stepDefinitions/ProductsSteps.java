package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ProductsSteps extends DriverFactory {

	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String arg1) throws Throwable {
		// use getDriver() to invoke WebDriver
	}

	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) throws Throwable {

	}

	@Then("^user should be presented with a promo alert$")
	public void user_should_be_presented_with_a_promo_alert() throws Throwable {

	}

}
