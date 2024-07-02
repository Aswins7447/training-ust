package com.ust.Allbirds.testcases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.Allbirds.base.TestSetUp;
import com.ust.Allbirds.dataproviders.Logindata;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.LoginAndRegistrationPage;
import com.ust.Allbirds.reportlistener.ExtentReportListener;

@Listeners(ExtentReportListener.class)

public class TestLoginPage extends TestSetUp {
	WebDriver driver;
	HomePage hp;
	LoginAndRegistrationPage lrp;

	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = invokeBrowser();
		openSite();
		hp = new HomePage(driver);
		lrp = new LoginAndRegistrationPage(driver);
		timedelay(5000);
		handlePopUp(HomePage.closepopup);

	}

	@Test(priority = 0, dataProvider = "invalidLogindetails", dataProviderClass = Logindata.class)
	public void verifyInvalidLogin(String mail, String pwd) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clickProfileIcon();
		lrp.setEmail(mail);
		lrp.setPassword(pwd);
		lrp.clicksignIn();
		assertTrue(lrp.checkErrorMessage());
	}

	@Test(priority = 1, dataProvider = "validLogindetails", dataProviderClass = Logindata.class)
	public void verifyValidLogin(String mail, String pwd) {
		hp.clickProfileIcon();
		lrp.setEmail(mail);
		lrp.setPassword(pwd);
		lrp.clicksignIn();
		assertTrue(lrp.checkLogoutButton());
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
