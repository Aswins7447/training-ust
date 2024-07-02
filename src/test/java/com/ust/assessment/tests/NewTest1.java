package com.ust.assessment.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.assessment.base.Setup;
import com.ust.assessment.utilities.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class NewTest1 extends Setup {
	WebDriver driver;
  @Test
  public void f() {
	  assertTrue(false);
  }
//  @BeforeMethod
//  public void beforeMethod() {
//	  
//  }

  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
	  driver = invokeBrowser("chrome");
	  opensite();
  }

}
