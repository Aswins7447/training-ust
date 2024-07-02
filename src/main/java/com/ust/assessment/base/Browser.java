package com.ust.assessment.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {

	private static WebDriver driver;

	public static WebDriver getChrome() {

		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--disable-infobars", "--disable-notifications", "--start-maximized");
		driver = new ChromeDriver(coptions);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}

	public static WebDriver getEdge() {

		EdgeOptions eoptions = new EdgeOptions();
		eoptions.addArguments("--disable-infobars", "--disable-notifications", "--start-maximized");
		driver = new EdgeDriver(eoptions);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}

	public static WebDriver getFirefox() {

		FirefoxOptions eoptions = new FirefoxOptions();
		eoptions.addArguments("--disable-infobars", "--disable-notifications", "--start-maximized");
		driver = new FirefoxDriver(eoptions);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;

	}
	
}
