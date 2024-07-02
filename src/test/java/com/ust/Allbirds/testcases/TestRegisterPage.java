package com.ust.Allbirds.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.ust.Allbirds.base.ReusableFunctions;
import com.ust.Allbirds.dataproviders.RegisterData;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.LoginAndRegistrationPage;
import com.ust.Allbirds.reportlistener.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class TestRegisterPage extends ReusableFunctions {
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
		hp.clickProfileIcon();
	}

	@Test(priority = 0, dataProvider = "invalidRegisterdetails", dataProviderClass = RegisterData.class)
	public void verifyInvalidRegister(String fname, String lname, String regmail, String regpwd, String cpwd) {
		lrp.setFirstname(fname);
		lrp.setLastname(lname);
		lrp.setRegEmail(regmail);
		lrp.setregPassword(regpwd);
		lrp.setConfirmPwd(cpwd);
		lrp.clickRegisterButton();
		AssertJUnit.assertTrue(lrp.checkRegisterError());
	}

	@Test(priority = 1, dataProvider = "validRegisterdetails", dataProviderClass = RegisterData.class)
	public void verifyValidRegister(String fname, String lname, String regmail, String regpwd, String cpwd) {
		lrp.setFirstname(fname);
		lrp.setLastname(lname);
		lrp.setRegEmail(regmail);
		lrp.setregPassword(regpwd);
		lrp.setConfirmPwd(cpwd);
		lrp.clickRegisterButton();
		AssertJUnit.assertTrue(lrp.checkLogoutButton());
	}


	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
