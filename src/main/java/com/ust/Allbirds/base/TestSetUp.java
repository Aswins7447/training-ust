package com.ust.Allbirds.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ust.Allbirds.pages.HomePage;

public class TestSetUp extends ReusableFunctions {
	private WebDriver driver;
	

//	@BeforeClass
//	public void setUp() throws InterruptedException {
//		driver = invokeBrowser();
//		openSite();
//		//HomePage hp = new HomePage(driver);
//		timedelay(5000);
//		handlePopUp(HomePage.closepopup);
//	}



	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
