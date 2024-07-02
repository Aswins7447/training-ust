package com.ust.Allbirds.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.Allbirds.utilities.Configuration;

public class WomensPage {
	WebDriver driver;
	public static Properties prop;

	public WomensPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();

	}

	@FindBy(xpath = "//p[contains(text(),'Women')]")
	private WebElement womenslink;

	@FindBy(xpath = "//h4[contains(text(),'Shoes')]")
	private WebElement shoeslink;

	@FindBy(xpath = "(//h4[contains(@class,'typography--quaternary-heading')])[2]")
	private WebElement bestsellerslink;

	@FindBy(xpath = "//h4[contains(text(),'Apparel & More')]")
	private WebElement apparelandmorelink;

	public void clickwomenslink() {
		womenslink.click();
	}

	public String clickshoeslink() {
		shoeslink.click();
		driver.getCurrentUrl();
		String actUrl = driver.getCurrentUrl();
		return actUrl;
	}

	public String clickbestsellerslink() {
		bestsellerslink.click();
		return driver.getCurrentUrl();
	}

	public String clickapparelandmorelink() {
		apparelandmorelink.click();
		driver.getCurrentUrl();
		String actUrl = driver.getCurrentUrl();
		return actUrl;
	}

}
