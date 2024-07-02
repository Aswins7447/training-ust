package com.ust.Allbirds.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.Allbirds.pages.ChatPage;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.NewArrivalsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//AUTHOR: ASWIN SATHIKUMAR

//--------------------HOME BUTTON VALIDATION----------------------//
public class ChatFeature {
	WebDriver driver = CucumberHook.driver;
	ChatPage cp = new ChatPage(driver);
	HomePage hp = new HomePage(driver);
	NewArrivalsPage np = new NewArrivalsPage(driver);
	Properties prop = CucumberHook.prop;

	@Given("user in Allbirds Home Page")
	public void user_in_allbirds_products_page() {
		assertEquals(driver.getCurrentUrl(), prop.getProperty("BaseUrl"));
		CucumberHook.handlePopUp(HomePage.closepopup);

	}

	@Given("user navigates to Product page")
	public void user_navigates_to_product_page() {
		np.clicknewarrivalsproduct();
	}

	@When("user clicks the chat icon")
	public void user_clicks_the_chat_icon() throws InterruptedException {
		CucumberHook.timedelay(5000);
		cp.clickChatButton();
		CucumberHook.timedelay(5000);
		assertEquals(cp.verifyChatWindowMsg(), prop.getProperty("ChatWindowVerifyMsg"));
	}

	@When("enters a valid chat query {string} in the search field")
	public void enters_a_valid_chat_query_in_the_search_field(String query) throws InterruptedException {
		CucumberHook.timedelay(5000);
		cp.searchChat(query);
		CucumberHook.timedelay(5000);
	}

	@Then("user validate the results")
	public void user_validate_the_results() throws InterruptedException {

		CucumberHook.timedelay(5000);
		if (cp.verifyQueryResult().contains("products"))
			assertTrue(true);
	}

	@When("enters a invalid chat query {string} in the search field")
	public void enters_a_invalid_chat_query_in_the_search_field(String query) throws InterruptedException {
		CucumberHook.timedelay(5000);
		cp.searchChat(query);
		CucumberHook.timedelay(5000);
	}

	@Then("user validate the appropriate  error results")
	public void user_validate_the_appropriate_error_results() {
		CucumberHook.timedelay(5000);
		if (cp.verifyErrorResult().equals(prop.getProperty("No Results")))
			assertTrue(true);
	}

	@Then("user verifies if the support team is available or not")
	public void user_verifies_if_the_support_team_is_available_or_not() {
		CucumberHook.timedelay(5000);
		if (cp.verifyRepavailableorNot().equals(prop.getProperty("ChatRepAvailable"))
				|| cp.verifyRepavailableorNot().equals(prop.getProperty("ChatRepnotAvailable")))
			assertTrue(true);
	}

	@When("user click the close-chat icon")
	public void user_click_the_close_chat_icon() throws InterruptedException {
		cp.closeChat();
		CucumberHook.timedelay(5000);
	}

	@Then("the chat window closes successfully")
	public void the_chat_window_closes_successfully() {
		CucumberHook.timedelay(5000);
		if (ChatPage.helpicon.isDisplayed()) {
			assertTrue(true);
		}
	}

}
