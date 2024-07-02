package com.ust.Allbirds.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.ust.Allbirds.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//AUTHOR: ASWIN SATHIKUMAR
//--------------------HOME BUTTON VALIDATION----------------------//

public class HomeButton {
	WebDriver driver = CucumberHook.driver;
	HomePage hp = new HomePage(driver);
	Properties prop = CucumberHook.prop;

	@Given("I am in Allbirds Home Page")
	public void i_am_in_allbirds_home_page() {
		CucumberHook.timedelay(5000);
		CucumberHook.handlePopUp(HomePage.closepopup);
		CucumberHook.openSite();
	}
	@Given("user navigates to the rerun page")
	public void user_navigates_to_the_rerun_page() {
		CucumberHook.handlePopUp(HomePage.closepopup);
		assertEquals(driver.getCurrentUrl(),prop.getProperty("RerunPageURL"));
		hp.navigatetoRerunPage();
	}

	@When("user clicks the AllBirds Home button")
	public void user_clicks_the_all_birds_home_button() {
		hp.navigatetoAllbirdsHome();
	}

	@Then("user should be in AllBirds Home page.")
	public void user_should_be_in_all_birds_home_page() {
		assertEquals(driver.getCurrentUrl(), prop.getProperty("BaseUrl"));
	}

}
