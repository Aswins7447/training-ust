package com.ust.Allbirds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferalPage {
	WebDriver driver;

	public ReferalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	WebElement email;

	@FindBy(xpath = "//button[@aria-label=\"Next\"]")
	WebElement nextbutton;
	@FindBy(xpath = "//div[@role='heading']")
	WebElement message;

	public void setemail(String mail) {
		email.sendKeys(mail);
	}

	public void clickNextButton() {
		nextbutton.click();
	}

	public String getResultMessage() {
		return message.getText();
	}

}
