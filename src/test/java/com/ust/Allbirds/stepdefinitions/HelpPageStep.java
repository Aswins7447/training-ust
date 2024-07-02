package com.ust.Allbirds.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import com.ust.Allbirds.pages.HelpPage;
import com.ust.Allbirds.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//AUTHOR: ANNA SUSAN JOSE

//--------------------HELP PAGE VALIDATION--------------------//

public class HelpPageStep {
	WebDriver driver = CucumberHook.driver;
	HomePage hp = new HomePage(driver);
	HelpPage hpp = new HelpPage(driver);
	Properties prop = CucumberHook.prop;

	@Given("User is on the homepage.")
	public void user_is_on_the_homepage() throws InterruptedException {
		CucumberHook.timedelay(5000);
		CucumberHook.handlePopUp(HomePage.closepopup);
		String actUrl = driver.getCurrentUrl();
		String expUrl = prop.getProperty("BaseUrl");
		AssertJUnit.assertEquals(actUrl, expUrl);

	}

	@Then("click on the FAQ\\/Contact Us link on help.")
	public void click_on_the_faq_contact_us_link_on_help() {
		CucumberHook.timedelay(5000);
		String actUrl = hpp.clickfaqlink();
		AssertJUnit.assertEquals(actUrl, prop.getProperty("HelpUrl"));
	}

	@Then("click on the appropriate  FAQ.")
	public void click_on_the_appropriate_faq() {
		hpp.clickquestion();
	}

	@Then("click on the back option.")
	public void click_on_the_back_option() {
		hpp.clickback();

	}

}
