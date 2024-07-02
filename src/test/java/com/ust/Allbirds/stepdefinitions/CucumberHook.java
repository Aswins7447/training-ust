package com.ust.Allbirds.stepdefinitions;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHook {

	public static WebDriver driver;
	public static Properties prop;
	private static FileReader file;
	private ExtentReports extent;
	private ExtentTest test;
	private static WebDriverWait wait;

	// PATH OF THE PROPERTIES FILE
	public static String PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\Config.properties";

	@Before
	public void setup() {
		prop = CucumberHook.getPropertyValue();
		driver = invokeBrowser(prop.getProperty("Browser"));
		driver.get(prop.getProperty("BaseUrl"));
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//"
				+ "//Cucumber//" + "allbirds" + CucumberHook.getTimeStamp() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("All Birds");
		// this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take the screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Add it to the report
			test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
		} else {
			// Take the screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Add it to the report
			test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
			test.pass("Test passed");
		}
		extent.flush();
		driver.quit();

	}

	// --------------------DRIVER FOR CHROME BROWSER--------------------//
	public static WebDriver getChrome() {

		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--disable-infobars", "--disable-notifications", "--start-maximized");
		driver = new ChromeDriver(coptions);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}

	// --------------------DRIVER FOR EDGE BROWSER--------------------//
	public static WebDriver getEdge() {

		EdgeOptions eoptions = new EdgeOptions();
		eoptions.addArguments("--disable-infobars", "--disable-notifications", "--start-maximized");
		driver = new EdgeDriver(eoptions);
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}

	// --------------------INVOKE BROWSER--------------------//
	public static WebDriver invokeBrowser(String browserChoice) {

		try {
			switch (browserChoice.toLowerCase()) {
			case "chrome":
				driver = getChrome();
				return driver;
			case "msedge":
				driver = getEdge();
				return driver;
			default:
				throw new Exception("Invalid browser name in property file!");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	// --------------------GETTING TIMESTAMP IN FORMAT:
	// yyyy.MM.dd.HH.mm.ss--------------------//
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	// --------------------HANDLING POP-UP--------------------//
	public static void handlePopUp(WebElement closepopup) {
		try {
			wait.until((ExpectedConditions.visibilityOf(closepopup)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		closepopup.click();
	}

	// --------------------PROPERTIES FILE IMPLEMENTATION--------------------//
	public static Properties getPropertyValue() {

		if (prop == null) {
			prop = new Properties();
		}

		try {
			file = new FileReader(PATH);
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Properties file not found!");
			e.printStackTrace();
		}
		return prop;
	}

	// --------------------WAIT-------------------//
	public static void timedelay(int wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// --------------------OPEN SITE-------------------//
	public static void openSite() {
		String url = prop.getProperty("BaseUrl");
		driver.get(url);
	}


}
