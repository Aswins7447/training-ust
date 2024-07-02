package com.ust.assessment.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

@CucumberOptions
	(dryRun = true,
	monochrome = false,
	features = {"src/test/resources/feature/sample.feature"},
	glue = {"runner"}
	//plugin = {"html:target/cucumber-html/cucumber.html", "json:target/cucumber-json/cucumber.json"},
	//tags = ""
	)

public class CucumberRunner extends AbstractTestNGCucumberTests {
	WebDriver driver;

	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
}


