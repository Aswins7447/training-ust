package com.ust.Allbirds.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.Allbirds.base.ReusableFunctions;
import com.ust.Allbirds.utilities.Configuration;

public class HelpPage {
	WebDriver driver;
	public static Properties prop;

	public HelpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = Configuration.initProperties();

	}

	@FindBy(xpath = "//a[contains(text(),'FAQ/Contact Us')]")
	private WebElement FAQlink;

	@FindBy(xpath = "//a[contains(text(),'Do Allbirds run true to size?')]")
	private WebElement question;

	@FindBy(xpath = "//a[@class='gladlyHC-answerDetail-backLink']")
	private WebElement back;

	/*public void clickfaqlink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(FAQlink));
		element.click();*/
	
	
	public String clickfaqlink() {
		FAQlink.click();
		String actUrl = driver.getCurrentUrl();
		return actUrl;
	}
		

	public void clickquestion() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(question));
		element.click();
		}

	
	public void clickback() {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(back);
//		actions.click();
//		actions.perform();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", back);
//		back.click();
		driver.navigate().back();
		
	}
}
