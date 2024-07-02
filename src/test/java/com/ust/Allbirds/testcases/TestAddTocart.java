package com.ust.Allbirds.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.ust.Allbirds.base.ReusableFunctions;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.ProductPage;
import com.ust.Allbirds.pages.SearchPage;

public class TestAddTocart extends ReusableFunctions {
	WebDriver driver;
	HomePage hp;
	SearchPage sp;
	ProductPage pdtpg;

	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = invokeBrowser();
		openSite();
		hp = new HomePage(driver);
		timedelay(5000);
		handlePopUp(HomePage.closepopup);
		pdtpg = new ProductPage(driver);

	}

}
