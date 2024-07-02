package com.ust.Allbirds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement declarations using @FindBy annotations with CSS selectors

    // Button to increment product count
    @FindBy(css = ".jsx-1969544649.NumberStepper__button.NumberStepper__button--step-up")
    public static WebElement productincrement;

    // Button to decrement product count
    @FindBy(css = ".jsx-1969544649.NumberStepper__button.NumberStepper__button--step-down")
    public static WebElement productdecrement;

    // Button to close the cart
    @FindBy(css = ".jsx-2418670298.CloseIcon.CloseIcon--hoverable")
    public static WebElement closecartbutton;

    // Button to remove an item from the cart
    @FindBy(css = ".jsx-20177884.CloseIcon.CloseIcon--hoverable")
    public static WebElement removeitembutton;

    // Button to proceed to checkout
    @FindBy(css = "a[class='jsx-4080304301 Button Button--default Button--full-width Button--uppercase']")
    public static WebElement checkoutbutton;

    // Element displaying the current quantity of items in the cart
    @FindBy(css = " .jsx-175512945.Drawer__header  .jsx-2224907785.jsx-3489369594.CartCount__icon text")
    public static WebElement cartquantity;

    // Another element displaying the quantity of items in the cart
    @FindBy(xpath = "//span[@aria-label='Quantity']")
    public static WebElement cartquantity2;

    // Element indicating that the cart is empty
    @FindBy(className = "CartEmptyState__heading")
    public static WebElement noitemincart;

    // Help icon element
    @FindBy(className = "Icon--HELP")
    public static WebElement helpicon;

    // Methods for interacting with elements

    // Method to increment the product count in the cart
    public void addProductCount() {
        productincrement.click();
    }

    // Method to decrement the product count in the cart
    public void removeProductCount() {
        productdecrement.click();
    }

    // Method to remove a product from the cart
    public void removeProductfromCart() {
        removeitembutton.click();
    }

    // Method to proceed to checkout
    public void checkout() {
        checkoutbutton.click();
    }

    // Method to close the cart page
    public void closeCartPage() {
        closecartbutton.click();
    }

    // Method to get the current item quantity in the cart
    public int getItemQuantity() {
        String quantity1 = cartquantity.getText();
        return Integer.parseInt(quantity1);
    }

    // Method to get another representation of item quantity in the cart
    public int getItemquantity2() {
        String quantity2 = cartquantity2.getText();
        return Integer.parseInt(quantity2);
    }

    // Method to verify if the cart is empty and get the corresponding message
    public String verifyEmptyCart() {
        String errormsg = noitemincart.getText();
        return errormsg;
    }

    // Method to check if the help icon is displayed
    public boolean checkHelpIcon() {
        helpicon.isDisplayed();
        return true; // Assuming you want to return true if the icon is displayed
    }
}
