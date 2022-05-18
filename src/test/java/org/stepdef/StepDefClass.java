package org.stepdef;

import org.base.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefClass extends BaseClass{
	@Given("User is on the instagram login page")
	public void user_is_on_the_instagram_login_page() {
		browserLaunch("https://www.instagram.com/?hl=en");
		maximize();
		impWait(10);
		System.out.println("Browser launched");
	}

	@When("User should enter the username and password")
	public void user_should_enter_the_username_and_password() {
		findElementName("username").sendKeys("Sundar");
		findElementName("password").sendKeys("Sundar@123");
		System.out.println("username & password entered");
	}

	@When("User should click the Login button")
	public void user_should_click_the_Login_button() {
		findElementXpath("//button[@class='sqdOP  L3NKy   y3zKF     ']").click();
		System.out.println("Login");
	}

	@Then("User should verify the success message")
	public void user_should_verify_the_success_message() {
		System.out.println("Successfully entered");
	}

}

