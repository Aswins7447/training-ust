package com.ust.Allbirds.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.WomensPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//AUTHOR: ANNA SUSAN JOSE

//--------------------WOMENS PAGE VALIDATION--------------------//

public class WomenPageStep {
	WebDriver driver = CucumberHook.driver;
	HomePage hp = new HomePage(driver);
	WomensPage wp = new WomensPage(driver);
	Properties prop = CucumberHook.prop;

	@Given("User is in the homepage.")
	public void the_user_is_in_the_homepage() {
		CucumberHook.timedelay(5000);
		CucumberHook.handlePopUp(HomePage.closepopup);
		String actUrl = driver.getCurrentUrl();
		String expUrl = prop.getProperty("BaseUrl");
		AssertJUnit.assertEquals(actUrl, expUrl);
	}

	@Then("click on the womens link.")
	public void click_on_the_womens_link() {
		wp.clickwomenslink();
	}

	@Then("click on the  shoes link.")
	public void click_on_the_shoes_link() {
		String actUrl = wp.clickshoeslink();
		CucumberHook.timedelay(5000);
		driver.navigate().back();
		AssertJUnit.assertEquals(actUrl, prop.getProperty("Shoeslink"));

	}

	@Then("click on the  bestsellers link.")
	public void click_on_the_bestsellers_link() {
		CucumberHook.timedelay(7000);
		wp.clickwomenslink();
		CucumberHook.timedelay(5000);
		String actUrl = wp.clickbestsellerslink();

		AssertJUnit.assertEquals(actUrl, prop.getProperty("Bestsellerslink"));
	}

	@Then("click on the apparel&more  link.")
	public void click_on_the_apparel_more_link() {
		wp.clickwomenslink();
		String actUrl = wp.clickapparelandmorelink();
		CucumberHook.timedelay(5000);
		AssertJUnit.assertEquals(actUrl, prop.getProperty("Apparelandmore"));
	}
}
