package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DesktopsSteps {
    @Then("I select sort by name Z to A {string}")
    public void iSelectSortByNameZToA(String option) {
        new DesktopPage().clickOnSortByPosition();
        new DesktopPage().selectSortByAToZ(option);
    }

    @When("I click on currency and select GBP")
    public void iClickOnCurrencyAndSelectGBP() {
        new HomePage().chooseGBP();
    }

    @And("I select sort by name A to Z {string}")
    public void iSelectSortByNameAToZ(String option) {
        new DesktopPage().clickOnSortByPosition();
        new DesktopPage().selectSortByAToZ(option);
    }

    @And("I select product {string}")
    public void iSelectProduct(String product) {
        new DesktopPage().clickOnProduct(product);
    }

    @And("I should see the product text {string}")
    public void iShouldSeeTheProductText(String pName) {
        Assert.assertEquals(new ProductPage().getProductWelcomeText(), pName);
    }

    @And("I enter Qty to one {string}")
    public void iEnterQtyToOne(String qua) {
        new ProductPage().clearAndAddQuantity(qua);
    }

    @And("I click on Add to Cart button")
    public void iClickOnAddToCartButton() {
        new ProductPage().clickAddToCart();
    }

    @And("I should see the success message {string}<product>{string}")
    public void iShouldSeeTheSuccessMessageProduct(String msg, String productName) {
        Assert.assertTrue(new ProductPage().isSuccessMessageAppearing());
    }

    @And("I click on shopping cart link into success message")
    public void iClickOnShoppingCartLinkIntoSuccessMessage() {
        new ProductPage().clickOnShoppingCart();
    }

    @And("I should see the shopping text")
    public void iShouldSeeTheShoppingText() {
        Assert.assertTrue(new ShoppingCartPage().isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
    }

    @And("I should see the product name {string}")
    public void iShouldSeeTheProductName(String pName) {
        Assert.assertEquals(new ShoppingCartPage().getProductName(), pName);
    }

    @And("I should see the model {string}")
    public void iShouldSeeTheModel(String model) {
        Assert.assertEquals(new ShoppingCartPage().getModelText(), model);
    }

    @Then("I should see the total {string}")
    public void iShouldSeeTheTotal(String total) {
        Assert.assertEquals(new ShoppingCartPage().getTotalText(), total);
    }

    @And("I should see the success message Success: You have added {string} to your shopping cart!")
    public void iShouldSeeTheSuccessMessageSuccessYouHaveAddedToYourShoppingCart(String productName) {
        String expectedMessage = "Success: You have added " + productName + " to your shopping cart!";
        Assert.assertEquals(new ProductPage().getSuccessMessage().substring(0,expectedMessage.length()),expectedMessage);
    }
}
