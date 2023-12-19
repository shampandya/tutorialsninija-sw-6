package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenuListField;

    @CacheLookup
    @FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Desktops']")
    WebElement desktopTab;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNoteBooksTab;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement componentsTab;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccounts;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginAccountText;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencySelector;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement currencyGBP;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllComponents']")
    WebElement showAllComponents;


    public void chooseGBP() {
        clickOnElement(currencySelector);
        log.info("Clicking on currency selector : " + currencySelector.toString());
        clickOnElement(currencyGBP);
        log.info("Clicking on currency GBP : " + currencyGBP.toString());
    }

    public void selectMenu(String menu) {
        if (Objects.equals(menu, "Show All Desktops")) {
            mouseHoverToElementAndClick(showAllDesktops);
            log.info("Hovering mouse and Clicking on show all desktops : " + showAllDesktops.toString());

        } else if (Objects.equals(menu, "Show All Laptops & Notebooks")) {
            mouseHoverToElementAndClick(showAllLaptopsAndNotebooks);
            log.info("Hovering mouse and Clicking on show all Laptops and Notebooks : " + showAllLaptopsAndNotebooks.toString());

        } else if (Objects.equals(menu, "Show All Components")) {
            mouseHoverToElementAndClick(showAllComponents);
            log.info("Hovering mouse and Clicking on show all Components : " + componentsTab.toString());
        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

    public void mouseHoverAndClickOnDesktop() {
        mouseHoverToElementAndClick(desktopTab);
        log.info("Hovering mouse and clicking on Desktops tab : " + desktopTab.toString());
    }

    public void mouseHoverAndClickOnLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(laptopsAndNoteBooksTab);
        log.info("Hovering mouse and clicking on Laptops and Notebooks tab : " + laptopsAndNoteBooksTab.toString());
    }

    public void mouseHoverAndClickOnComponents() {
        mouseHoverToElementAndClick(componentsTab);
        log.info("Hovering mouse and clicking on Components tab : " + componentsTab.toString());
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountsList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccounts);
        log.info("Clicking on My Accounts Tab : " + myAccounts.toString());
    }

    public String getRegisterAccountText() {
        log.info("Getting text from Register Account : " + registerAccountText);
        return getTextFromElement(registerAccountText);
    }

    public String getLoginAccountText() {
        log.info("Getting text from Login Account : " + loginAccountText);
        return getTextFromElement(loginAccountText);
    }

}
