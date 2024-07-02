package com.ust.Allbirds.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.Allbirds.utilities.Configuration;

public class ReusableFunctions {

	static WebDriver driver;
	Browsers bs = new Browsers();

	public static Properties prop;
	public WebDriverWait wait;

	public ReusableFunctions() {
		prop = Configuration.initProperties();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/************ INVOKE BROWSER ************/
	public WebDriver invokeBrowser() {
		String browser_choice = prop.getProperty("Browser");
		try {
			if (browser_choice.equals("chrome")) {
				driver = bs.getChromeDriver();
			} else if (browser_choice.equals("edge")) {
				driver = bs.getEdgeDriver();
			} else {
				throw new Exception("Invalid browser name ");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return driver;
	}

	/********** OpenSite *******************/
	public void openSite() {
		String url = prop.getProperty("BaseUrl");
		driver.get(url);
	}

	/********** TAKE SCREENSHOT *********/
	public void takeScreenShot(String filepath) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/********** GETTING TIMESTAMP IN FORMAT: yyyy.MM.dd.HH.mm.ss *********/
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	/********** Handling pop-up *********/
	public void handlePopUp(WebElement closepopup) {
		wait.until((ExpectedConditions.visibilityOf(closepopup)));
		closepopup.click();
	}

	/********** WAIT *********/
		public void timedelay(int wait) {
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
