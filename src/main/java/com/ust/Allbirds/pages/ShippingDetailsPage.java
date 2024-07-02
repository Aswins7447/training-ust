package com.ust.Allbirds.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.Allbirds.utilities.Configuration;

public class ShippingDetailsPage {
	WebDriver driver;
	public static Properties prop;

	public ShippingDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();
	}

	@FindBy(id = "checkout_buyer_accepts_marketing")
	public WebElement checkbox1;

	@FindBy(id = "checkout_shipping_address_id")
	public WebElement dropdown;

	@FindBy(id = "checkout_shipping_address_country")
	public WebElement country;

	@FindBy(id = "checkout_shipping_address_first_name")
	public WebElement firstname;

	@FindBy(id = "checkout_shipping_address_last_name")
	public WebElement lastname;

	@FindBy(id = "checkout_shipping_address_company")
	public WebElement company;

	@FindBy(id = "checkout_shipping_address_address1")
	public WebElement address;

	@FindBy(id = "checkout_shipping_address_address2")
	public WebElement apartment;

	@FindBy(id = "checkout_shipping_address_city")
	public WebElement city;

	@FindBy(id = "checkout_shipping_address_province")
	public WebElement state;

	@FindBy(id = "checkout_shipping_address_zip")
	public WebElement zipcode;

	/*
	 * @FindBy(id = "checkout_buyer_accepts_sms") public WebElement checkbox2;
	 */

	@FindBy(id = "continue_button")
	public WebElement continuebutton;

	@FindBy(id = "error-for-first_name")
	public WebElement errorfirstname;

	@FindBy(id = "error-for-last_name")
	public WebElement errorlastname;

	@FindBy(id = "error-for-address1")
	public WebElement erroraddress;

	@FindBy(id = "error-for-city")
	public WebElement errorcity;

	@FindBy(id = "error-for-zip")
	public WebElement errorzipcode;

	public void checkbox1() {
		checkbox1.click();
	}

	public void dropdown(String selectdropdown) {
		dropdown.clear();
		dropdown.sendKeys(selectdropdown);
	}

	public void country(String selectcountry) {
		country.clear();
		country.sendKeys(selectcountry);
	}

	public void firstname(String fname) {
		firstname.clear();
		firstname.sendKeys(fname);
	}

	public void lastname(String lname) {
		lastname.clear();
		lastname.sendKeys(lname);
	}

	public void companyaddress(String selectaddress) {
		address.clear();
		address.sendKeys(selectaddress);
	}

	public void company(String selectcompany) {
		company.clear();
		company.sendKeys(selectcompany);
	}

	public void apartment(String selectappartment) {
		apartment.clear();
		apartment.sendKeys(selectappartment);
	}

	public void city(String selectcity) {
		city.clear();
		city.sendKeys(selectcity);
	}

	public void state(String selectstate) {
		state.clear();
		state.sendKeys(selectstate);
	}

	public void zipcode(String selectzipcode) {
		zipcode.clear();
		zipcode.sendKeys(selectzipcode);
	}

	/*
	 * public void checkbox2() { checkbox2.click(); }
	 */
	public void continuebutton() {
		continuebutton.click();
	}

	public String checkShippingUrl() {
		driver.getCurrentUrl();
		String actUrl = driver.getCurrentUrl();
		return actUrl;
	}

	/*
	 * public boolean checkerrorfirstname() { String expMessage =
	 * prop.getProperty("ShippingFirstName"); if(errorfirstname.isDisplayed()&&
	 * errorfirstname.getText().equals(expMessage)) { return true; } return false; }
	 * public boolean checkerrorlastname() { String expMessage =
	 * prop.getProperty("ShippingLastName"); if(errorlastname.isDisplayed()&&
	 * errorlastname.getText().equals(expMessage)) { return true; } return false; }
	 * public boolean checkerroraddress() { String expMessage =
	 * prop.getProperty("ShippingAddress"); if(erroraddress.isDisplayed()&&
	 * erroraddress.getText().equals(expMessage)) { return true; } return false; }
	 * public boolean checkerrorcity() { String expMessage =
	 * prop.getProperty("ShippingCity"); if( errorcity.isDisplayed()&&
	 * errorcity.getText().equals(expMessage)) { return true; } return false; }
	 */
	public boolean checkerrorzipcode() {
		String expMessage = prop.getProperty("ShippingZipcode");
		if (errorzipcode.isDisplayed() && errorzipcode.getText().equals(expMessage)) {
			return true;
		}
		return false;
	}

}
