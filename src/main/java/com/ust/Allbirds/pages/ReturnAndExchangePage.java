package com.ust.Allbirds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReturnAndExchangePage {
	WebDriver driver;

	public ReturnAndExchangePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ReturnsPageCountrySelector__select")
	WebElement country;
	@FindBy(xpath = "//button[contains(@class, 'Button--default')]")
	WebElement getstartedbutton;
	@FindBy(id = "input-FS-vXkCWvCJH8Rla7vPqc")
	WebElement ordno;
	@FindBy(id = "input-GIep_u1O0fA0dr63DlLrD")
	WebElement zip;
	@FindBy(xpath = "(//span[@class='base-button__text'])[1]")
	WebElement returnButton;
	@FindBy(css = ".order-lookup__errors[role=\"alert\"]")
	WebElement message;
	
	public void selectCountry(String cnty) {
		Select dropdown = new Select(country);
		dropdown.selectByValue(cnty);
	}

	public void clickGetStartedButton() {
		getstartedbutton.click();
	}
	
	public void setOrderDetails(String orderNo, String zipcode) {
		ordno.sendKeys(orderNo);
		zip.sendKeys(zipcode);
		returnButton.click();
	}
	
	public String getErrorMessage() {
		String erroeMessage=message.getText();
		return erroeMessage;
	}

}
