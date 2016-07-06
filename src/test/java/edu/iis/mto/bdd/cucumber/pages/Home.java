package edu.iis.mto.bdd.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Home {
	@FindBy(id = "welcome-message")
	private WebElement welcomeMessage;

	private WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openHomePage() {
		driver.get("http://localhost:8080/#/home");
	}

	public void checkMessage(String userFirstName) {
		assertThat(welcomeMessage.getText(), equalTo("Witaj " + userFirstName));
	}
}
