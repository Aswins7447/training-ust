package com.ust.Allbirds.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.Allbirds.base.TestSetUp;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.reportlistener.ExtentReportListener;

@Listeners(ExtentReportListener.class)


public class TestHomePage extends TestSetUp {
	WebDriver driver;
	HomePage hp;

	@Test(priority = 1)
	public void testSendUpdatetoEmail() {
		//handlePopUp(HomePage.closepopup);
		hp.scrollToGetUpdates(prop.getProperty("emailforupdates"));
		hp.verifyGetUpdate();
		assertEquals(hp.verifyGetUpdate(), prop.getProperty("SuccessMessageforSendUpdatestoEmailFunctionality"));
	}

	@Test(priority = 2)
	public void testChangeofCountryContent() {
		//handlePopUp(HomePage.closepopup);
		hp.scrollToChangeCountry();
		assertEquals(driver.getCurrentUrl(), prop.getProperty("AllBirdsURLforUKRegion"));
	}

	@BeforeClass
	public void beforeMethod() {
		driver = invokeBrowser();
		openSite();
		hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		handlePopUp(HomePage.closepopup);
	}

	@AfterTest()
	public void afterMethod() {
		driver.quit();
	}
}
