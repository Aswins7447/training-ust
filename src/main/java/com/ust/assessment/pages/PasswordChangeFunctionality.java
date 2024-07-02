package com.ust.assessment.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordChangeFunctionality {
	WebDriver driver;
	
	public PasswordChangeFunctionality(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "oxd-userdropdown-tab")
	public WebElement dropdown;
	
	@FindBy(linkText = "Change Password")
	public WebElement changepassbutton;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	public WebElement currentpassword;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	public WebElement newpassword;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
	public WebElement confirmpassword;
	
	@FindBy(css = "button[type='submit']")
	public WebElement savebutton;
	
	
	public void clickDropDown()
	{
		dropdown.click();
		
	}
	public void clickPassButton()
	{
		changepassbutton.click();
		
	}
	public void enterCurrentPass(String cpass)
	{
		currentpassword.sendKeys(cpass);	
	}
	public void enterNewPassword(String newpass)
	{
		newpassword.sendKeys(newpass);
	}
	public void enterConfirmPassowrd(String conpass)
	{
		confirmpassword.sendKeys(conpass);
	}
	public String clickSaveButton()
	{
		savebutton.click();
		return driver.getCurrentUrl();
	}
	public String verifySaveInvalid()
	{
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		return alertText;
	}
	public String verifySaveValid()
	{
		return str;
	}
	
}
