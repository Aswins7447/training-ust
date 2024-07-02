package com.ust.Allbirds.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.ust.Allbirds.base.TestSetUp;
import com.ust.Allbirds.pages.CartPage;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.NewArrivalsPage;
import com.ust.Allbirds.reportlistener.ExtentReportListener;

@Listeners(ExtentReportListener.class)


public class TestNewArrivals extends TestSetUp {
	WebDriver driver;
	HomePage hp;
	CartPage cp;
	NewArrivalsPage np;
	

	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = invokeBrowser();
		openSite();
		hp = new HomePage(driver);
		np = new NewArrivalsPage(driver);
		cp = new CartPage(driver);
		timedelay(5000);
		handlePopUp(HomePage.closepopup);
	}

	@Test(priority = 0)
	public void verifynewarrivalscheckoutpage() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		np.clicknewarrivalsproduct();
		np.clicklimitededition();
		np.clicksize();
		np.clickaddtocart();
		np.clickviewcartandcheckout();
		cp.checkout();
		String actUrl = np.checkShippingUrl();
		AssertJUnit.assertEquals(actUrl, prop.getProperty("ShippingUrl"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
