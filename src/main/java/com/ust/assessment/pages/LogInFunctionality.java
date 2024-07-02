package com.ust.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInFunctionality {
	WebDriver driver;
	
	public LogInFunctionality(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "name")
	public WebElement username;	
	
	@FindBy(name = "password")
	public WebElement password;	
	
	@FindBy(className = "oxd-button")
	public WebElement Loginbutton;	
	
	@FindBy(className = "oxd-alert-content-text")
	public WebElement errormessage;	
	
	@FindBy(className = "oxd-text--span")
	public WebElement errormessagenull;	
	
	
	public void enterusername(String uname) 
	{
		username.sendKeys(uname);	
	}
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void LogIn()
	{
		Loginbutton.click();
	}
	public String verifyLogin()
	{
		String verifiedsuccess  = driver.getCurrentUrl();
		return verifiedsuccess;
	}
	public String verifyError()
	{
		String verifiederror = errormessage.getText();
		return verifiederror;
	}
	public String verifyErrorforNull()
	{
		String verifynull = errormessagenull.getText();
		return verifynull;
	}
	
}
