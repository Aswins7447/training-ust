package com.ust.Allbirds.stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.KidsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//AUTHOR: ANNA SUSAN JOSE

//--------------------KIDS PAGE VALIDATION--------------------//

public class KidsPageStep {
	WebDriver driver = CucumberHook.driver;
	HomePage hp = new HomePage(driver);
	KidsPage kp = new KidsPage(driver);
	Properties prop = CucumberHook.prop;

	@Given("The user is in the homepage.")
	public void the_user_is_in_the_homepage() {
		CucumberHook.timedelay(5000);
		CucumberHook.handlePopUp(HomePage.closepopup);
		String actUrl = driver.getCurrentUrl();
		String expUrl = prop.getProperty("BaseUrl");
		AssertJUnit.assertEquals(actUrl, expUrl);
	}

	@Then("click on the kids link.")
	public void click_on_the_kids_link() {
		CucumberHook.timedelay(5000);
		kp.clickKidsLink();
	}

	@Then("click on the little kids link.")
	public void click_on_the_little_kids_link() {
		String actUrl = kp.clickLittlekids();
		CucumberHook.timedelay(5000);
		driver.navigate().back();
		AssertJUnit.assertEquals(actUrl, prop.getProperty("LittlekidsUrl"));

	}

	@Then("click on the big kids link.")
	public void click_on_the_big_kids_link() {
		CucumberHook.timedelay(5000);
		kp.clickKidsLink();
		CucumberHook.timedelay(7000);
		String actUrl = kp.clickBigkids();
		AssertJUnit.assertEquals(actUrl, prop.getProperty("BigkidsUrl"));

	}
}
