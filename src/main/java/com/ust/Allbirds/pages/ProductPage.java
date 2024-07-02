package com.ust.Allbirds.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.Allbirds.utilities.Configuration;

public class ProductPage {

	WebDriver driver;
	public static Properties prop;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();
	}
	
	@FindBy(xpath = "(//span[@class='jsx-3492423137 jsx-2863553625 SizeButton-content'])[1]")
	private WebElement availsize;
	
	@FindBy(xpath = "(//span[@class='jsx-3492423137 jsx-2863553625 SizeButton-content'])[6]")
	private WebElement soldOut;
	
	@FindBy(id = "add-to-cart")
	private WebElement addtocart;
	
	public void selectSize() {
		availsize.click();
	}
	public void clickAddtoCartButton() {
		addtocart.click();
	}
	
}

