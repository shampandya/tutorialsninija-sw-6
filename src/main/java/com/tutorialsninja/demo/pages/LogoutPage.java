package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Utility {

        private static final Logger log = LogManager.getLogger(LogoutPage.class.getName());

        @CacheLookup
        @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
        WebElement logoutText;

        public String getTextFromLogout() {
            log.info("Getting text from logout page : " + logoutText.toString());
            return getTextFromElement(logoutText);
        }
}
