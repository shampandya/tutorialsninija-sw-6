package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {

    private static final Logger log = LogManager.getLogger(CheckOutPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-checkout']//input[@value='guest']")
    WebElement guestCheckoutRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonBillingDetails;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement regionOrState;

    @CacheLookup
    @FindBy(name = "comment")
    WebElement commentBox;

    @CacheLookup
    @FindBy(xpath = "//input[@name = 'agree']")
    WebElement termsAndConditionsRadioBox;

    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement continueButtonCommentDetails;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement paymentMethodWarning;

    public String getCheckoutText() {
        log.info("Getting text from checkout page : " + checkoutText.toString());
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        log.info("Getting New Customer text : " + newCustomerText.toString());
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
        log.info("Clicking on Guest checkout radio button : " + guestCheckoutRadioButton.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Clicking on continue button : " + continueButton.toString());
    }

    public void clickOnContinueBillingButton() {
        clickOnElement(continueButtonBillingDetails);
        log.info("Clicking on continue button in billing details : " + continueButtonBillingDetails.toString());
    }

    public void clickOnContinueCommentButton() {
        clickOnElement(continueButtonCommentDetails);
        log.info("Clicking on continue button in comments details : " + continueButtonCommentDetails.toString());
    }

    public void enterBillingDetailsFirstName(String inputFirstName) {
        sendTextToElement(firstName, inputFirstName);
        log.info("Sending firstname to billing details : " + firstName.toString());
    }

    public void enterBillingDetailsLastName(String inputLastName) {
        sendTextToElement(lastName, inputLastName);
        log.info("Sending lastname to billing details : " + lastName.toString());
    }

    public void enterBillingDetailsEmail(String inputEmail) {
        sendTextToElement(email, inputEmail);
        log.info("Sending email to billing details : " + email.toString());
    }

    public void enterBillingDetailsTelephone(String inputTelephone) {
        sendTextToElement(telephone, inputTelephone);
        log.info("Sending telephone to billing details : " + telephone.toString());
    }

    public void enterBillingDetailsAddress(String inputAddress) {
        sendTextToElement(address, inputAddress);
        log.info("Sending address to billing details : " + address.toString());
    }

    public void enterBillingDetailsCity(String inputCity) {
        sendTextToElement(city, inputCity);
        log.info("Sending city to billing details : " + city.toString());
    }

    public void enterBillingDetailsPostcode(String inputPostcode) {
        sendTextToElement(postCode, inputPostcode);
        log.info("Sending postcode to billing details : " + postCode.toString());
    }

    public void enterBillingDetailsCountry(String inputCountry) {
        selectByVisibleTextFromDropDown(country, inputCountry);
        log.info("Selecting country to billing details from dropdown : " + country.toString());
    }

    public void enterBillingDetailsRegionOrState(String inputRegion) {
        selectByVisibleTextFromDropDown(regionOrState, inputRegion);
        log.info("Selecting region to billing details from dropdown : " + regionOrState.toString());
    }

    public void enterComment(String comment) {
        sendTextToElement(commentBox, comment);
        log.info("Sending comments to billing details : " + commentBox.toString());
    }

    public void clickOnAgreeToTermsAndConditions() {
        clickOnElement(termsAndConditionsRadioBox);
        log.info("Clicking on terms and condition check box : " + termsAndConditionsRadioBox.toString());
    }

    public Boolean isPaymentWarningAppearing() {
        log.info("Getting a payment method required warning message : " + paymentMethodWarning);
        return getTextFromElement(paymentMethodWarning).contains("Warning: Payment method required!");
    }
}
