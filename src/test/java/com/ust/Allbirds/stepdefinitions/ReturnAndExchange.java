package com.ust.Allbirds.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.Allbirds.base.ReusableFunctions;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.ReturnAndExchangePage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReturnAndExchange {
	WebDriver driver;
	HomePage hp;
	ReturnAndExchangePage rep;
	Properties prop = CucumberHook.prop;
//	@Before
//	public void setUp() {
//		driver = invokeBrowser();
//		openSite();
//		hp = new HomePage(driver);
//		rep = new ReturnAndExchangePage(driver);
//		handlePopUp(hp.closepopup);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}

	@Given("user is in the home page")
	public void user_is_in_the_home_page() {
		String actUrl = driver.getCurrentUrl();
		String expUrl = prop.getProperty("BaseUrl");
		assertEquals(actUrl, expUrl);
	}
	
	@When("the user scrolls down and clicks on the return\\/exchange link")
	public void the_user_scrolls_down_and_clicks_on_the_return_exchange_link() {
		hp.clickReturnLink();
	    
	}
	
	@When("is redirected to the return and exchange page")
	public void is_redirected_to_the_return_and_exchange_page() {
		String actUrl = driver.getCurrentUrl();
		String expUrl = prop.getProperty("ReturnUrl");   
		assertEquals(actUrl, expUrl);

	}
	
	@When("user Selects a {string} from dropdown")
	public void user_selects_a_from_dropdown(String cnty) {
		rep.selectCountry(cnty);   
	}
	
	@When("clicks on getStarted button")
	public void clicks_on_get_started_button() {
	    rep.clickGetStartedButton();
	}
	
	@When("enters the {string} and {string}")
	public void enters_the_and(String orderno, String zipcode) {
	    rep.setOrderDetails(orderno, zipcode);
	}
	
	@Then("{string} error message is displayed.")
	public void error_message_is_displayed(String expMsg) {
	    String actMessage=rep.getErrorMessage();
	    assertEquals(actMessage,expMsg );
	}

}
