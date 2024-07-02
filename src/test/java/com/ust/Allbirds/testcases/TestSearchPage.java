package com.ust.Allbirds.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.ust.Allbirds.base.TestSetUp;
import com.ust.Allbirds.dataproviders.SearchData;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.SearchPage;
import com.ust.Allbirds.reportlistener.ExtentReportListener;

@Listeners(ExtentReportListener.class)


public class TestSearchPage extends TestSetUp {
	WebDriver driver;
	HomePage hp;
	SearchPage sp;

	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = invokeBrowser();
		openSite();
		hp = new HomePage(driver);
		sp = new SearchPage(driver);
		timedelay(5000);
		handlePopUp(HomePage.closepopup);
	}

	@Test(priority = 0, dataProvider = "invalidproduct", dataProviderClass = SearchData.class)
	public void verifyInvalidSearch(String searchproduct) throws InterruptedException {
		hp.clicksearchicon();
		sp.enterinvalidsearchfield(searchproduct);
		AssertJUnit.assertTrue(sp.checkErrorMessage());
	}

	@Test(priority = 1, dataProvider = "validproduct", dataProviderClass = SearchData.class)
	public void verifyvalidSearch(String searchproduct) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clicksearchicon();
		sp.entersearchfield(searchproduct);
		sp.checkMessage();

	}

	@Test(priority = 2)
	public void verifynullSearch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.clicksearchicon();
		sp.enteremptysearchfield();

	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
