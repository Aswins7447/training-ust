package com.ust.Allbirds.pages;

import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.Allbirds.utilities.Configuration;

public class LoginAndRegistrationPage {
	WebDriver driver;
	public static Properties prop;

	public LoginAndRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();
	}

	@FindBy(id = "CustomerEmail")
	private WebElement email;
	@FindBy(id = "CustomerPassword")
	private WebElement password;
	@FindBy(id = "FirstName")
	private WebElement firstname;
	@FindBy(id = "LastName")
	private WebElement lastname;
	@FindBy(id = "Email")
	private WebElement regemail;
	@FindBy(id = "CreatePassword")
	private WebElement regpassword;
	@FindBy(id = "CustomerPasswordConfirmation")
	private WebElement cnfpassword;
	@FindBy(css = "#create_customer > input.btn.btn--full")
	private WebElement registerbutton;
	@FindBy(xpath = "//input[@value='Sign In']")
	private WebElement signInButton;
	@FindBy(linkText = "LOGOUT")
	private WebElement logoutbutton;
	@FindBy(xpath = "(//div[@class='errors'])[1]")
	private WebElement errorMessage;
	@FindBy(className = "default-address")
	private WebElement address;
	@FindBy(xpath = "(//div[@class='errors'])[2]")
	private WebElement regmessages;

	public void setEmail(String mail) {
		email.sendKeys(mail);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clicksignIn() {
		signInButton.click();
	}

	public void setFirstname(String fname) {
		firstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void setRegEmail(String regmail) {
		regemail.sendKeys(regmail);
	}

	public void setregPassword(String regpwd) {
		regpassword.sendKeys(regpwd);
	}

	public void setConfirmPwd(String cpwd) {
		cnfpassword.sendKeys(cpwd);
	}

	public void clickRegisterButton() {
		registerbutton.click();
	}

	public boolean checkRegisterError() {
		try {
			String actMessage = regmessages.getText();
			System.out.println(actMessage);
			if (actMessage.equals(prop.getProperty("Nullpwd")) || actMessage.equals(prop.getProperty("Nullmail"))
					|| actMessage.contains(prop.getProperty("ExistingUserError"))) {
				return true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Error message web element not found.");
		}
		return false;

	}

	public boolean checkErrorMessage() {
		String expMessage = prop.getProperty("LoginErrorMessage");
		if (errorMessage.isDisplayed() && errorMessage.getText().equals(expMessage)) {
			return true;
		}
		return false;
	}

	public boolean checkLogoutButton() {
		if (logoutbutton.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean checkAddress() {
		if (address.isDisplayed()) {
			return false;
		}
		return true;
	}

}
