package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends Utility {

    private static final Logger log = LogManager.getLogger(AccountCreationPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountCreationText;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueAfterAccountCreation;


    public String getAccountCreationMessage() {
        log.info("Getting account creation text " + accountCreationText.toString());
        return getTextFromElement(accountCreationText);
    }

    public void clickOnContinueAfterAccountCreation() {
        log.info("Clicking on continue after account button " + continueAfterAccountCreation.toString());
        clickOnElement(continueAfterAccountCreation);
    }
}
