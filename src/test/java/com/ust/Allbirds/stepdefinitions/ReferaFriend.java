package com.ust.Allbirds.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.ReferalPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReferaFriend{
	WebDriver driver;
	HomePage hp;
	ReferalPage rp;
	Properties prop = CucumberHook.prop;

	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		String actUrl = driver.getCurrentUrl();
		String expUrl = prop.getProperty("BaseUrl");
		assertEquals(actUrl, expUrl);
	}

	@When("the user scrolls down and clicks on the refer a friend link")
	public void the_user_scrolls_down_and_clicks_on_the_refer_a_friend_link() {
		hp.clickReferalLink();
	}

	@When("is redirected to the refer a friend page")
	public void is_redirected_to_the_refer_a_friend_page() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		String actUrl = driver.getCurrentUrl();
		String expUrl = prop.getProperty("ReferalUrl");
		assertEquals(actUrl, expUrl);
	}

	@When("enters their email address as {string}")
	public void enters_their_email_address_as(String email) {
		rp.setemail(email);

	}

	@When("clicks on the Next button")
	public void clicks_on_the_next_button() {
		rp.clickNextButton();
		CucumberHook.timedelay(5000);
	}

	@When("enters their friends email address as {string}")
	public void enters_their_friends_email_address_as(String mail) {
		rp.setemail(mail);
	}

	@Then("the {string} message should be displayed")
	public void the_message_should_be_displayed(String string) {
		String actMessage = rp.getResultMessage();
		String expMessage = prop.getProperty("ReferMessage");
		assertEquals(actMessage, expMessage);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
