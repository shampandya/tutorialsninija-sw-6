package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.CheckOutPage;
import com.tutorialsninja.demo.pages.LaptopAndNoteBookPage;
import com.tutorialsninja.demo.pages.MacBookPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.utility.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class LaptopsAndNotebooksSteps {
    @And("I select filter option as {string}")
    public void iSelectFilterOptionAs(String filterOption) {
        new LaptopAndNoteBookPage().clickOnSortByFilter();
        new LaptopAndNoteBookPage().selectPriceHighToLow(filterOption);
    }

    @Then("I should get the product arranged in price high to low order")
    public void iShouldGetTheProductArrangedInPriceHighToLowOrder() {
        List expectedSorting = new LaptopAndNoteBookPage().beforeSorting();
        List actualSorting = new LaptopAndNoteBookPage().afterSorting();
        Assert.assertEquals(actualSorting, expectedSorting);
    }

    @And("I click on MacBook product")
    public void iClickOnMacBookProduct() {
        new LaptopAndNoteBookPage().clickOnMacbook();
    }

    @And("I should navigate to MacBook page and see the page heading {string}")
    public void iShouldNavigateToMacBookPageAndSeeThePageHeading(String expectedMessage) {
        Assert.assertEquals(new MacBookPage().getTextFromMacBook(), expectedMessage);
    }

    @And("I click on Add to Cart")
    public void iClickOnAddToCart() {
        new MacBookPage().clickOnAddToCart();
    }

    @And("I should see the success add to cart message")
    public void iShouldSeeTheSuccessAddToCartMessage() {
        Assert.assertTrue(new MacBookPage().isSuccessMessageAppearing(), "Message Doesn't Appear");
    }

    @And("I click on shopping cart link in success message")
    public void iClickOnShoppingCartLinkInSuccessMessage() {
        new MacBookPage().clickOnShoppingCart();
    }

    @And("I should navigate to shopping cart page and see the welcome message")
    public void iShouldNavigateToShoppingCartPageAndSeeTheWelcomeMessage() {
        Assert.assertTrue(new ShoppingCartPage().isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
    }

    @And("I should see the product name {string} in the shopping cart")
    public void iShouldSeeTheProductNameInTheShoppingCart(String expectedMessage) {
        Assert.assertEquals(new ShoppingCartPage().getProductName(), expectedMessage, "Product Name Doesn't appear");
    }

    @And("I change the quantity to two {string}")
    public void iChangeTheQuantityToTwo(String expectedMessage) {
        new ShoppingCartPage().clearAndAddQuantity(expectedMessage);
    }

    @And("I click on update tab")
    public void iClickOnUpdateTab() {
        new ShoppingCartPage().clickOnUpdate();
    }

    @And("I should see the shopping cart updated message")
    public void iShouldSeeTheShoppingCartUpdatedMessage() {
        Assert.assertTrue(new ShoppingCartPage().isSuccessMessageAppearing("Success: You have modified your shopping cart!"), "Cart not modified");
    }

    @And("I should see the total price {string}")
    public void iShouldSeeTheTotalPrice(String expectedMessage) {
        Assert.assertEquals(new ShoppingCartPage().getTotalText(), expectedMessage, "Total not matched");
    }

    @And("I click on checkout button")
    public void iClickOnCheckoutButton() {
        new ShoppingCartPage().clickOnCheckout();
    }

    @And("I should redirected to the checkout page and see the checkout {string}text")
    public void iShouldRedirectedToTheCheckoutPageAndSeeTheCheckoutText(String expectedMessage) {
        Assert.assertEquals(new CheckOutPage().getCheckoutText(), expectedMessage, "Checkout not displayed");
    }

    @And("I should see the new customer {string} text")
    public void iShouldSeeTheNewCustomerText(String expectedMessage) {
        Assert.assertEquals(new CheckOutPage().getNewCustomerText(), expectedMessage, "New Customer not displayed");
    }

    @And("I click on guest checkout")
    public void iClickOnGuestCheckout() {
        new CheckOutPage().clickOnGuestCheckoutRadioButton();
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        new CheckOutPage().clickOnContinueButton();
    }

    @And("I enter first name {string} in billing details")
    public void iEnterFirstNameInBillingDetails(String fName) {
        new CheckOutPage().enterBillingDetailsFirstName(fName);
    }

    @And("I enter last name {string} in billing details")
    public void iEnterLastNameInBillingDetails(String lName) {
        new CheckOutPage().enterBillingDetailsLastName(lName);
    }

    @And("I enter email address in billing details")
    public void iEnterEmailAddressInBillingDetails() {
        new CheckOutPage().enterBillingDetailsEmail("Dhyan" + Utility.getRandomString(4) + "@grr.la");
    }

    @And("I enter phone number {string} in the billing details")
    public void iEnterPhoneNumberInTheBillingDetails(String pNumber) {
        new CheckOutPage().enterBillingDetailsTelephone(pNumber);
    }

    @And("I enter billing address {string} in the billing details")
    public void iEnterBillingAddressInTheBillingDetails(String address) {
        new CheckOutPage().enterBillingDetailsAddress(address);
    }

    @And("I enter city {string} in the billing details")
    public void iEnterCityInTheBillingDetails(String city) {
        new CheckOutPage().enterBillingDetailsCity(city);
    }

    @And("I enter postcode {string}  in the billing details")
    public void iEnterPostcodeInTheBillingDetails(String postcode) {
        new CheckOutPage().enterBillingDetailsPostcode(postcode);
    }

    @And("I enter country {string} in the billing details")
    public void iEnterCountryInTheBillingDetails(String country) {
        new CheckOutPage().enterBillingDetailsCountry(country);
    }

    @And("I enter state {string} in the billing details")
    public void iEnterStateInTheBillingDetails(String state) {
        new CheckOutPage().enterBillingDetailsRegionOrState(state);
    }

    @And("I click on continue in the billing details")
    public void iClickOnContinueInTheBillingDetails() {
        new CheckOutPage().clickOnContinueBillingButton();
    }

    @And("I enter comment {string} in the comment area")
    public void iEnterCommentInTheCommentArea(String comment) {
        new CheckOutPage().enterComment(comment);
    }

    @And("I click on terms and conditions checkbox")
    public void iClickOnTermsAndConditionsCheckbox() {
        new CheckOutPage().clickOnAgreeToTermsAndConditions();
    }

    @And("I click on continue in comment section")
    public void iClickOnContinueInCommentSection() {
        new CheckOutPage().clickOnContinueCommentButton();
    }
    @Then("I should check for the payment warning method")
    public void iShouldCheckForThePaymentWarningMethod() {
        Assert.assertTrue(new CheckOutPage().isPaymentWarningAppearing(), "Payment Warning not displayed");
    }


}
