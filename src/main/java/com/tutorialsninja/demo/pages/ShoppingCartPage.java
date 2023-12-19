package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDateText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement modelText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input[@type='text']")
    WebElement quantityBox;

    @CacheLookup
    @FindBy(xpath = "//i[@class = 'fa fa-refresh']")
    WebElement refreshButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successMessageRefresh;

    @CacheLookup
    @FindBy(css = "a.btn.btn-primary")
    WebElement checkoutButton;

    public Boolean isShoppingCartAppearing() {
        log.info("Checking for shopping cart text : " + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText).contains("Shopping Cart");
    }

    public String getProductName() {
        log.info("Getting product name text in shopping cart : " + productNameText.toString());
        return getTextFromElement(productNameText);
    }

    public Boolean isDeliveryDateAppearing(String date) {
        log.info("Getting delivery date in shopping cart : " + deliveryDateText.toString());
        return getTextFromElement(deliveryDateText).contains(date);
    }

    public String getModelText() {
        log.info("Getting model details in shopping cart : " + modelText.toString());
        return getTextFromElement(modelText);
    }

    public String getTotalText() {
        log.info("Getting total amount in shopping cart : " + totalText.toString());
        return getTextFromElement(totalText);
    }

    public void clearAndAddQuantity(String quantity) {
        quantityBox.clear();
        sendTextToElement(quantityBox, quantity);
        log.info("Sending quantity to quantity box in shopping cart : " + quantityBox.toString());
    }

    public void clickOnUpdate() {
        clickOnElement(refreshButton);
        log.info("Clicking on refresh button : " + refreshButton);
    }

    public Boolean isSuccessMessageAppearing(String message) {
        log.info("Checking for success message after refreshing the product : " + successMessageRefresh.toString());
        return getTextFromElement(successMessageRefresh).contains("Success: You have modified your shopping cart!");
    }

    public void clickOnCheckout() {
        clickOnElement(checkoutButton);
        log.info("Clicking on logout button : " + refreshButton);
    }
}
