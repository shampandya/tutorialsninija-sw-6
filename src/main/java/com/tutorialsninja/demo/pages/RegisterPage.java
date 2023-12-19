package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    @CacheLookup
    @FindBy(name = "firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(name = "email")
    WebElement email;

    @CacheLookup
    @FindBy(name = "telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(name = "confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(name = "newsletter")
    WebElement newsletter;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueAfterPrivacyButton;


    public void sendFirstName(String inputFirstName) {
        sendTextToElement(firstName, inputFirstName);
        log.info("Sending firstname to register page : " + firstName.toString());
    }

    public void sendLastName(String inputLastName) {
        sendTextToElement(lastName, inputLastName);
        log.info("Sending lastname to register page : " + lastName.toString());
    }

    public void sendEmail(String gmail) {
        sendTextToElement(email, gmail);
        log.info("Sending email to register page : " + email.toString());
    }

    public void sendTelephone(String inputTelephone) {
        sendTextToElement(telephone, inputTelephone);
        log.info("Sending telephone to register page : " + telephone.toString());
    }

    public void sendPassword(String inputPassword) {
        sendTextToElement(password, inputPassword);
        log.info("Sending password to register page : " + password.toString());
    }

    public void sendConfirmPassword(String inputConfirmPassword) {
        sendTextToElement(confirmPassword, inputConfirmPassword);
        log.info("Sending confirm password to register page : " + confirmPassword.toString());
    }

    public void clickOnSubscribeToNewsletter() {
        clickOnElement(newsletter);
        log.info("Clicking on newsletter check box : " + newsletter.toString());
    }

    public void clickOnPrivacyPolicy() {
        clickOnElement(privacyPolicy);
        log.info("Clicking on privacy policy check box : " + privacyPolicy.toString());
    }

    public void clickOnContinueAfterPrivacyButton() {
        clickOnElement(continueAfterPrivacyButton);
        log.info("Clicking on continue button : " + continueAfterPrivacyButton.toString());
    }
}
