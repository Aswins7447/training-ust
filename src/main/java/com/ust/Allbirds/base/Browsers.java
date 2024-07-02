package com.ust.Allbirds.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Browsers {

	WebDriver driver;

	public WebDriver getChromeDriver() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-infobars");
		co.addArguments("--disable--notifications");
		co.addArguments("--start-maximized");
		driver = new ChromeDriver(co);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;
	}

	public WebDriver getEdgeDriver() {
		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--disable-infobars");
		eo.addArguments("--disable--notifications");
		eo.addArguments("--start-maximized");
		driver = new EdgeDriver(eo);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;
	}
}
