package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopAndNoteBookPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Objects;

public class TopMenuSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {
    }

    @When("I mouse hover and click on topmenu options {string}")
    public void iMouseHoverAndClickOnTopmenuOptions(String menu) {
        if (Objects.equals(menu, "Desktops")) {
            new HomePage().mouseHoverAndClickOnDesktop();
        } else if (Objects.equals(menu, "Laptops & Notebooks")) {
            new HomePage().mouseHoverAndClickOnLaptopsAndNotebooks();
        } else if (Objects.equals(menu, "Components")) {
            new HomePage().mouseHoverAndClickOnComponents();
        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

    @And("I mouse hover and click on topmenu sub options {string}")
    public void iMouseHoverAndClickOnTopmenuSubOptions(String submenu) {
        new HomePage().selectMenu(submenu);
    }

    @Then("I should navigate to corresponding page successfully and verify the page heading {string}")
    public void iShouldNavigateToCorrespondingPageSuccessfullyAndVerifyThePageHeading(String pageHeading) {
        if (Objects.equals(pageHeading, "Desktops")) {
            Assert.assertEquals(new DesktopPage().getDesktopText(), pageHeading);
        } else if (Objects.equals(pageHeading, "Laptops & Notebooks")) {
            Assert.assertEquals(new LaptopAndNoteBookPage().getLaptopAndNoteBookText(), pageHeading);
        } else if (Objects.equals(pageHeading, "Components")) {
            Assert.assertEquals(new ComponentsPage().getComponentsText(), pageHeading);
        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }
}
