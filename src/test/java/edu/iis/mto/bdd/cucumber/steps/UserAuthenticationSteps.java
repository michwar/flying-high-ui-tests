package edu.iis.mto.bdd.cucumber.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.cucumber.pages.Home;
import edu.iis.mto.bdd.cucumber.pages.Login;
import edu.iis.mto.bdd.model.FrequentFlyerMember;

public class UserAuthenticationSteps {
	private WebDriver driver;

	@Before
	public void init() {
		driver = new FirefoxDriver();
	}

	@Given("^(.*) is a registered Frequent Flyer$")
	public void givenARegisteredFrequentFlyer(String userEmail) {
	}

	@When("^(.*) authenticates with a valid email address and password$")
	public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember user) {
		Login loginPage = new Login(driver);
		loginPage.openLoginPage();
		loginPage.logInWithUserEmailAndUserPassword(user.getEmail(), user.getPassword());
	}

	@Then("^(.*) should be given access to (?:her|his) account$")
	public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember user) {
		Home homePage = new Home(driver);
		homePage.openHomePage();
		homePage.checkMessage(user.getFirstName());
	}

	@Given("^(.*) has logged on$")
	public void aUserHasLoggedOnAs(FrequentFlyerMember user) {
		Login loginPage = new Login(driver);
		loginPage.openLoginPage();
		loginPage.logInWithUserEmailAndUserPassword(user.getEmail(), user.getPassword());
	}

	@When("^(?:.*) views the home page$")
	public void whenAUserViewsTheHomePage() {
	}

	@After
	public void close() {
		driver.close();
	}

}
