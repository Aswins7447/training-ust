package com.ust.Allbirds.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.Allbirds.utilities.Configuration;

public class NewArrivalsPage {
	WebDriver driver;
	public static Properties prop;

	public NewArrivalsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();

	}

	@FindBy(css = "a.jsx-564596383.jsx-935521318.CarouselCard")
	private WebElement newarrivalsproduct;

	@FindBy(css = "div.jsx-3193500245.ColorSwatch")
	private WebElement limitededition;

	@FindBy(css = "li.jsx-2479093897.PdpSizeSelector__grid-item button[aria-label='Add Size 8']")
	private WebElement size;

	@FindBy(css = "button#add-to-cart")
	private WebElement addtocart;

	@FindBy(css = "button.Subtotal__view-cart")
	private WebElement viewcartandcheckout;

	@FindBy(css = "a.Button--uppercase[href*='cart']")
	private WebElement proceedtocheckout;
	
	

	public void clicknewarrivalsproduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(newarrivalsproduct));
		element.click();
	}

	public void clicklimitededition() {
		limitededition.click();
	}

	public void clicksize() {
		size.click();
	}

	public void clickaddtocart() {
		addtocart.click();
	}

	public void clickviewcartandcheckout() {
		viewcartandcheckout.click();
	}

	public void clickproceedtocheckout() {
		proceedtocheckout.click();
	}
	public String checkShippingUrl() {
		return driver.getCurrentUrl();
	}
}
