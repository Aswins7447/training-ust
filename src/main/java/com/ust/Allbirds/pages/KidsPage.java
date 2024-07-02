package com.ust.Allbirds.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.Allbirds.utilities.Configuration;

public class KidsPage {
	WebDriver driver;
	public static Properties prop;

	public KidsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();

	}

	@FindBy(xpath = "//button[@aria-label='Kids']")
	private WebElement kidslink;

	@FindBy(xpath = "//a[@href='/collections/little-kids']")
	private WebElement littlekidslink;

	@FindBy(xpath = "//a[@href='/collections/big-kids']")
	private WebElement bigkidslink;

	public void clickKidsLink() {
		
		kidslink.click();
	}

	public String clickLittlekids() {
		littlekidslink.click();
		driver.getCurrentUrl();
		String actUrl = driver.getCurrentUrl();
		return actUrl;
	}

	public String clickBigkids() {
		bigkidslink.click();
		driver.getCurrentUrl();
		String actUrl = driver.getCurrentUrl();
		return actUrl;
	}

}
