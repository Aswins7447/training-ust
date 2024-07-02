package com.ust.Allbirds.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPage {
    WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public ChatPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement declarations using @FindBy annotations with various locators

    // Button to initiate the chat
    @FindBy(id = "gladlyChat_container")
    public static WebElement chatbutton2;

    // Input field to search within the chat
    @FindBy(className = "dKAVoA")
    public static WebElement chatsearch;

    // Results of queries in the chat
    @FindBy(className = "fsOmjr")
    public static WebElement resultqueries;

    // Verification element for the chat window
    @FindBy(xpath = "//div[@class='GladlyChat-eJGGJA chLuaf']/span")
    public static WebElement verifychatwindow;

    // Element to verify search error
    //@FindBy(className = "cfETjl")
    @FindBy(className = "ijaESO")
    public static WebElement verifysearcherror;

    // Element indicating representative not available
    @FindBy(id = "gladlyStartChatButton")
    public static WebElement repnotavailable;

    // Button to close the chat window
    @FindBy(id = "closeButtonTitleId")
    public static WebElement closechatbutton;

    // Help icon element
    @FindBy(xpath = "//div[@class='jsx-2022988330 Icon Icon--HELP jsx-3907305029 jsx-85518033']")
    public static WebElement helpicon;

    // Methods for interacting with elements

    // Method to click on the chat button and initiate chat
    public void clickChatButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until((ExpectedConditions.visibilityOf(ChatPage.chatbutton2)));
        chatbutton2.click();
    }

    // Method to search within the chat
    public void searchChat(String query) {
        chatsearch.sendKeys(query);
    }

    // Method to verify message in the chat window
    public String verifyChatWindowMsg() {
        String str = verifychatwindow.getText();
        return str;
    }

    // Method to retrieve query results from the chat
    public String verifyQueryResult() {
        List<WebElement> elements = driver.findElements(By.className("fsOmjr"));
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement element : elements) {
            arrayList.add(element.getText().toLowerCase());
        }
        String str = "";
        for (int i = 0; i < Math.min(arrayList.size(), 3); i++) {
            str += arrayList.get(i) + " ";
        }
        return str;
    }

    // Method to verify error message in search results
    public String verifyErrorResult() {
        String errorstr = verifysearcherror.getText();
        return errorstr;
    }

    // Method to verify if representative is available or not
    public String verifyRepavailableorNot() {
        String valiadtestr = repnotavailable.getText();
        return valiadtestr;
    }

    // Method to close the chat window
    public void closeChat() {
        closechatbutton.click();
    }
}
