package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNoteBookPage extends Utility {

    private static final Logger log = LogManager.getLogger(LaptopAndNoteBookPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPath;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement dropDownPath;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNoteBookText;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookLink;

    public String getLaptopAndNoteBookText() {
        log.info("Getting text from Laptops and Notebooks page : " + laptopAndNoteBookText.toString());
        return getTextFromElement(laptopAndNoteBookText);
    }

    public ArrayList<String> expectedList() {
        // Get all the products name and stored into array list
        List<WebElement> products = productsPath;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public  void clickOnSortByFilter() {
        clickOnElement(dropDownPath);
        log.info("Clicking on SortBy filter drop down : " + dropDownPath.toString());
    }
    public void selectPriceHighToLow(String inputSelectPriceOrder) {
        selectByVisibleTextFromDropDown(dropDownPath, inputSelectPriceOrder);
        log.info("Selecting sort by Price(High>Low) option : " + dropDownPath.toString());
    }

    public List<Double> beforeSorting() {
        List<WebElement> product = productsPath;
        ArrayList<Double> originalList = new ArrayList<>();
        for (WebElement list : product) {
            String[] arr = list.getText().split("Ex Tax:");
            originalList.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        log.info("Taking actual sorted product prices : " + productsPath.toString());
        return originalList;
    }

    public List<Double> afterSorting() {
        //Collections.sort(beforeSorting(), Collections.reverseOrder());
        //System.out.println(beforeSorting());
        List<WebElement> products = productsPath;
        ArrayList<Double> afterSortingList = new ArrayList<>();
        for (WebElement newSortList : products) {
            String[] arr = newSortList.getText().split("Ex Tax:");
            afterSortingList.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        log.info("Taking the prices and sorting is by collection.sort : " + productsPath.toString());
        return afterSortingList;
    }

    public void clickOnMacbook() {
        clickOnElement(macBookLink);
        log.info("Clicking on MacBook product link : " + macBookLink);
    }
}
