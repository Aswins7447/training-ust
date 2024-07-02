package com.ust.Allbirds.pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.Allbirds.utilities.Configuration;

public class SearchPage {
	WebDriver driver;
	public static Properties prop;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();

	}

	@FindBy(id = "SearchBarMinimal__input")
	private WebElement searchfield;

	@FindBy(id = "SearchBarMinimal__input")
	private WebElement emptysearchfield;

	@FindBy(id = "SearchBarMinimal__input")
	private WebElement invalidsearchfield;

	@FindBy(css = ".SearchPage__search-stats .Paragraph")
	private WebElement validmsg;

	@FindBy(css = "div.jsx-2989221795.jsx-368081754")
	private WebElement invalidmsg;
	
	@FindBy(xpath = "(//div[contains(@class, 'Colorway__clickable-details')])[3]")
	private WebElement shoes;

	public void entersearchfield(String product) {
		searchfield.clear();
		searchfield.sendKeys(product);
	}

	public void enterinvalidsearchfield(String product) {
		invalidsearchfield.clear();
		invalidsearchfield.sendKeys(product);
	}

	public boolean checkMessage() {
		String message = validmsg.getText();
		String[] str = message.split("/s");
		if (str.length > 1) {
			int count = Integer.parseInt(str[1]);
			if (count > 0) {
				return true;
			}
		}
		return false;
	}

	public boolean checkErrorMessage() {
		String expMessage = prop.getProperty("invalidsearch");
		if (invalidmsg.isDisplayed() && invalidmsg.getText().equals(expMessage))
			;
		return true;
	}

	public void enteremptysearchfield() {
		searchfield.clear();
		emptysearchfield.sendKeys(Keys.ENTER);
	}
	
	public void selectProduct() {
		shoes.click();
	}
}
