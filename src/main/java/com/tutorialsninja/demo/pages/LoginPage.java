package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @CacheLookup
    @FindBy(name = "email")
    WebElement email;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void sendEmail(String inputEmail) {
        sendTextToElement(email, inputEmail);
        log.info("Sending email to login page: " + email.toString());
    }

    public void sendPassword(String inputPassword) {
        sendTextToElement(password, inputPassword);
        log.info("Sending password to login page: " + password.toString());
    }

    public void clickOnLogin() {
        clickOnElement(loginButton);
        log.info("Clicking on login button: " + loginButton.toString());
    }
}
