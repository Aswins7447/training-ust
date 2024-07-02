package com.ust.Allbirds.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		glue="com.ust.Allbirds.stepdefinitions", // Specifies the package where step definitions are located
		features = "classpath:feature",			 // Specifies the directory or location of the feature files
		plugin= {"pretty",						 // Plugins configuration for Cucumber test execution and reporting
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread",
				"html:Reports/cucumber-reports/index.html"}
		
)
 
public class CucumberRunners extends AbstractTestNGCucumberTests{
 }









