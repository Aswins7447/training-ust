package com.ust.assessment.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ust.assessment.utilities.ConfigReader;



public class Setup {

	public static WebDriver driver;
	public static Properties prop;

	public Setup() {
		prop = ConfigReader.getPropertyValue();
	}
	
	/************INVOKE BROWSER************/
	public static WebDriver invokeBrowser(String browserChoice) {

		try {
			switch(browserChoice.toLowerCase()) {
			case "chrome": driver = Browser.getChrome();
						   return driver;
			case "msedge": driver = Browser.getEdge();
			               return driver;
			default      : throw new Exception("Invalid browser name in property file!");
			}
		}
		catch(Exception e) {
			e.getMessage();			
		}
		return null;
	}
	
	/**********TAKE SCREENSHOT*********/
	public static void takeScreenshot(String filepath) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File srcFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/************Getting URL************/
	public static String opensite() {
		String url = prop.getProperty("BaseURL");
		System.out.println(url);
		driver.get(url);
		return url;
	}
	
	/**********GETTING TIMESTAMP IN FORMAT: yyyy.MM.dd.HH.mm.ss*********/
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

}
