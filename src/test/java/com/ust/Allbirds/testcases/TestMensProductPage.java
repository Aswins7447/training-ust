package com.ust.Allbirds.testcases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.Allbirds.base.ReusableFunctions;
import com.ust.Allbirds.pages.HomePage;
import com.ust.Allbirds.pages.MensProductPage;
import com.ust.Allbirds.reportlistener.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class TestMensProductPage extends ReusableFunctions {
	WebDriver driver;
	MensProductPage mp;
	HomePage hp;

	@Test(priority = 1)
	public void testSingleFilters() {
		handlePopUp(HomePage.closepopup);
		mp.scrollDown();
		mp.selectSingleFilter();
		if (driver.getCurrentUrl().contains("9") && driver.getCurrentUrl().contains("everyday")
				&& driver.getCurrentUrl().contains("black") && driver.getCurrentUrl().contains("canvas")) {
			assertTrue(true);
		}

	}

	@Test(priority = 2)
	public void TestMultiFilters() {
		handlePopUp(HomePage.closepopup);
		mp.scrollDown();
		mp.selectMultipleFilter();
		if (driver.getCurrentUrl().contains("9") && driver.getCurrentUrl().contains("9-5")
				&& driver.getCurrentUrl().contains("everyday") && driver.getCurrentUrl().contains("warm-weather")
				&& driver.getCurrentUrl().contains("black") && driver.getCurrentUrl().contains("blue")
				&& driver.getCurrentUrl().contains("canvas") && driver.getCurrentUrl().contains("tree")) {
			assertTrue(true);
		}
	}

	@BeforeMethod()
	public void beforeMethod() throws InterruptedException {
		driver = invokeBrowser();
		String url = prop.getProperty("MensProductPageURL");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		// Thread.sleep(20000);
		hp = new HomePage(driver);
		mp = new MensProductPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
