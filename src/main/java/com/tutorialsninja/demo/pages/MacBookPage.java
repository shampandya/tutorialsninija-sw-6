package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends Utility {

    private static final Logger log = LogManager.getLogger(MacBookPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/a[2]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    public String getTextFromMacBook() {
        log.info("Getting text from macbook page : " + macBookText.toString());
        return getTextFromElement(macBookText);
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
        log.info("Clicking on add to cart : " + addToCart.toString());
    }

    public Boolean isSuccessMessageAppearing() {
        log.info("Checking for product added to cart successfully : " + successMessage.toString());
        return getTextFromElement(successMessage).contains("Success: You have added MacBook to your shopping cart!");
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCart);
        log.info("Clicking on shopping cart : " + shoppingCart.toString());
    }
}
