package com.ust.Allbirds.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensProductPage {
    WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public MensProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElement declarations using @FindBy annotations with various locators

    // Example elements representing various filters/options on the page
    @FindBy(xpath = "(//span[@class='jsx-3492423137 jsx-2863553625 SizeButton-content'])[3]")
    public static WebElement size9;

    @FindBy(xpath = "(//span[@class='jsx-1643347871 Checkbox__checkmark'])[1]")
    public static WebElement bestforeveryday;

    @FindBy(xpath = "(//span[@class='jsx-1643347871 Checkbox__checkmark'])[6]")
    public static WebElement materiallightweight;

    @FindBy(css = ".jsx-512138434.ColorSwatch")
    public static WebElement hueblack;

    @FindBy(css = "button[aria-label='Add Size 9.5']")
    public static WebElement size9half;

    @FindBy(xpath = "(//span[@class='jsx-1643347871 Checkbox__checkmark'])[2]")
    public static WebElement bestforwarmweather;

    @FindBy(xpath = "(//span[@class='jsx-1643347871 Checkbox__checkmark'])[7]")
    public static WebElement materiallight;

    @FindBy(css = ".jsx-2002280460.ColorSwatch")
    public static WebElement hueblue;

    // Methods for interacting with elements

    // Method to select a single filter combination
    public void selectSingleFilter() {
        size9.click();
        bestforeveryday.click();
        materiallightweight.click();
        hueblack.click();
    }

    // Method to select multiple filter combinations
    public void selectMultipleFilter() {
        size9.click();
        size9half.click();
        bestforeveryday.click();
        bestforwarmweather.click();
        materiallightweight.click();
        materiallight.click();
        hueblack.click();
        hueblue.click();
    }

    // Method to scroll down the page using JavascriptExecutor
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
    }
}
