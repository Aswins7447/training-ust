package com.ust.Allbirds.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.ust.Allbirds.base.TestSetUp;
import com.ust.Allbirds.dataproviders.ShippingData;
import com.ust.Allbirds.pages.CartPage;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.ShippingDetailsPage;
import com.ust.Allbirds.reportlistener.ExtentReportListener;

@Listeners(ExtentReportListener.class)


public class TestShippingDetails extends TestSetUp {
	WebDriver driver;
	HomePage hp;
	CartPage cp;
	ShippingDetailsPage sdp;

	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = invokeBrowser();
		openSite();
		hp = new HomePage(driver);
		cp = new CartPage(driver);
		sdp = new ShippingDetailsPage(driver);
		timedelay(5000);
		handlePopUp(HomePage.closepopup);
		
		
	}

	@Test(priority = 0, dataProvider = "invalidshipping", dataProviderClass = ShippingData.class)
	public void verifyInvalidShipping(String selectdropdown, String selectcountry, String fname, String lname,
			String selectaddress, String company, String selectappartment, String selectcity, String selectstate,
			String selectzipcode) {
		hp.clickCartButton();
		cp.checkout();
		sdp.checkbox1();
		sdp.dropdown(selectdropdown);
		sdp.country(selectcountry);
		sdp.firstname(fname);
		sdp.lastname(lname);
		sdp.companyaddress(selectaddress);
		sdp.company(selectcountry);
		sdp.apartment(selectappartment);
		sdp.city(selectcity);
		sdp.state(selectstate);
		sdp.zipcode(selectzipcode);
		sdp.continuebutton();
		AssertJUnit.assertTrue(sdp.checkerrorzipcode());
	}

	@Test(priority = 1, dataProvider = "validshipping", dataProviderClass = ShippingData.class)
	public void verifyValidShipping(String selectdropdown, String selectcountry, String fname, String lname,
			String selectaddress, String company, String selectappartment, String selectcity, String selectstate,
			String selectzipcode) {
		hp.clickCartButton();
		cp.checkout();
		sdp.checkbox1();
		sdp.dropdown(selectdropdown);
		sdp.country(selectcountry);
		sdp.firstname(fname);
		sdp.lastname(lname);
		sdp.companyaddress(selectaddress);
		sdp.company(selectcountry);
		sdp.apartment(selectappartment);
		sdp.city(selectcity);
		sdp.state(selectstate);
		sdp.zipcode(selectzipcode);
		sdp.continuebutton();
		String actUrl = sdp.checkShippingUrl();
		AssertJUnit.assertEquals(actUrl, prop.getProperty("ShippingUrl"));
	}

	@Test(priority = 2, dataProvider = "nullshipping")
	public void verifyNullShipping() {
		hp.clickCartButton();
		cp.checkout();
		sdp.continuebutton();
		AssertJUnit.assertTrue(sdp.checkerrorzipcode());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
