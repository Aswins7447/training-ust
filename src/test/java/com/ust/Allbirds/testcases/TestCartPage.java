package com.ust.Allbirds.testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ust.Allbirds.base.TestSetUp;
import com.ust.Allbirds.pages.CartPage;
import com.ust.Allbirds.pages.HomePage;

public class TestCartPage extends TestSetUp {
    WebDriver driver;
    CartPage cartpage;
    HomePage homepage;

    @BeforeClass
    public void setUp() {
        driver = invokeBrowser(); // Initialize WebDriver and open the site
        openSite(); // Method to navigate to the site URL
        cartpage = new CartPage(driver); // Initialize CartPage instance
        timedelay(3000); // Custom method to introduce delay
        homepage = new HomePage(driver); // Initialize HomePage instance
        handlePopUp(HomePage.closepopup); // Handle popup using closepopup WebElement
    }

    @Test(priority = 1)
    public void testAddItemToCart() {
        cartpage.addProductCount(); // Method to add a product to the cart
        // Assert that item count is greater than zero in both representations
        assertTrue(cartpage.getItemQuantity() > 0 && cartpage.getItemquantity2() > 0);
    }

    @Test(priority = 2)
    public void testRemoveItemFromCart() {
        cartpage.removeProductfromCart(); // Method to remove a product from the cart
        // Assert that either item count is greater than zero or cart is empty message is displayed
        assertTrue(cartpage.getItemQuantity() > 0 || cartpage.verifyEmptyCart().equals(prop.getProperty("EmptyCartMsg")));
    }

    @Test(priority = 5)
    public void testCloseCartPage() {
        cartpage.closeCartPage(); // Method to close the cart page
        // Assert that help icon is displayed after closing the cart page
        assertFalse(cartpage.checkHelpIcon());
    }

    @Test(priority = 4)
    public void testCheckoutWithProduct() {
        cartpage.checkout(); // Method to proceed to checkout
        // Assert that checkout button is enabled
        assertTrue(CartPage.checkoutbutton.isEnabled());
    }

    @Test(priority = 3)
    public void testCheckoutWithoutProduct() {
        cartpage.removeProductfromCart(); // Method to remove product from cart
        // Assert that cart is empty message is displayed after removing all items
        assertTrue(cartpage.verifyEmptyCart().equals(prop.getProperty("EmptyCartMsg")));
    }

}
