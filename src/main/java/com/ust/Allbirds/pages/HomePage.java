package com.ust.Allbirds.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    JavascriptExecutor js;

    // Constructor to initialize the WebDriver and PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    // WebElement declarations using @FindBy annotations with various locators

    // Profile icon element
    @FindBy(css = "div.Icon.Icon--USER")
    private static WebElement profileIcon;

    // Close popup element
    @FindBy(className = "CloseIcon--hoverable")
    public static WebElement closepopup;

    // Email field for sending updates
    @FindBy(id = "EmailSignupModule__input")
    public static WebElement sendupdateemailfield;

    // Button to submit email for updates
    @FindBy(id = "EmailSignupModule__submit-button")
    public static WebElement sendupdateemailbutton;

    // Element to verify successful email updates submission
    @FindBy(xpath = "(//h2[@class='jsx-2714253045 typography--secondary-heading'])[5]")
    public static WebElement sendupdatesuccessverify;

    // Cart button element
    @FindBy(xpath = "//div[@class='jsx-2224907785 jsx-3489369594 CartCount__icon']")
    public static WebElement cartbutton;

    // Element to select country
    @FindBy(xpath = "//img[@alt='Shop Flag - UK']")
    public static WebElement selectcountry;

    // Element to navigate to ReRun page
    @FindBy(linkText = "ReRun")
    public static WebElement rerunpage;

    // Element to navigate to Allbirds home page
    @FindBy(className = "Icon--ALLBIRDS_LOGO")
    public static WebElement allbirdshome;

    // Element to navigate to Refer a Friend page
    @FindBy(linkText = "Refer a Friend")
    public static WebElement refer;

    // Search icon element
    @FindBy(className = "SearchIcon__icon-search")
    public WebElement searchicon;

    // Element to navigate to Returns/Exchanges page
    @FindBy(linkText = "Returns/Exchanges")
    private WebElement exchange;

    // Methods for interacting with elements

    // Method to scroll to the email field for updates, enter email, and submit
    public void scrollToGetUpdates(String email) {
        js.executeScript("window.scrollBy(0,1000)", "");
        sendupdateemailfield.sendKeys(email);
        sendupdateemailbutton.click();
    }

    // Method to click on the profile icon
    public void clickProfileIcon() {
        profileIcon.click();
    }

    // Method to verify successful email updates submission
    public String verifyGetUpdate() {
        String str = sendupdatesuccessverify.getText();
        return str;
    }

    // Method to scroll to the country selection and click
    public void scrollToChangeCountry() {
        js.executeScript("window.scrollBy(0,3500)", "");
        selectcountry.click();
    }

    // Method to navigate to the ReRun page
    public void navigatetoRerunPage() {
        rerunpage.click();
    }

    // Method to navigate to the Allbirds home page
    public void navigatetoAllbirdsHome() {
        allbirdshome.click();
    }

    // Method to click on the search icon
    public void clicksearchicon() {
        searchicon.click();
    }

    // Method to click on the Refer a Friend link after scrolling
    public void clickReferalLink() {
        js.executeScript("window.scrollBy(0,2500)", "");
        refer.click();
    }

    // Method to click on the Returns/Exchanges link after scrolling
    public void clickReturnLink() {
        js.executeScript("window.scrollBy(0,2500)", "");
        exchange.click();
    }

    // Method to click on the cart button
    public void clickCartButton() {
        cartbutton.click();
    }
}
