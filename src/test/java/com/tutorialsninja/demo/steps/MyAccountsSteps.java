package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyAccountsSteps {
    @When("I click on My Account tab")
    public void iClickOnMyAccountTab() {
        new HomePage().clickOnMyAccount();
    }

    @And("I call the method selectMyAccountOptions method and pass the parameter {string}")
    public void iCallTheMethodSelectMyAccountOptionsMethodAndPassTheParameter(String option) {
        new HomePage().selectMyAccountOptions(option);
    }

    @Then("I should see text as register account {string}")
    public void iShouldSeeTextAsRegisterAccount(String expectedText) {
        Assert.assertEquals(new HomePage().getRegisterAccountText(), expectedText);
    }

    @Then("I should see text as returning customer {string}")
    public void iShouldSeeTextAsReturningCustomer(String expectedText) {
        Assert.assertEquals(new HomePage().getLoginAccountText(), expectedText);
    }

    @And("I enter First Name {string} in register page")
    public void iEnterFirstNameInRegisterPage(String fName) {
        new RegisterPage().sendFirstName(fName);
    }

    @And("I enter Last Name {string} in register page")
    public void iEnterLastNameInRegisterPage(String lName) {
        new RegisterPage().sendLastName(lName);
    }

    @And("I enter Email {string} in register page")
    public void iEnterEmailInRegisterPage(String email) {
        new RegisterPage().sendEmail(email);
    }

    @And("I enter Telephone {string} in register page")
    public void iEnterTelephoneInRegisterPage(String telephone) {
        new RegisterPage().sendTelephone(telephone);
    }

    @And("I enter Password {string} in register page")
    public void iEnterPasswordInRegisterPage(String pass) {
        new RegisterPage().sendPassword(pass);
    }

    @And("I enter Confirm Password {string} in register page")
    public void iEnterConfirmPasswordInRegisterPage(String cPass) {
        new RegisterPage().sendConfirmPassword(cPass);
    }

    @And("I select Subscribe Yes radio button in register page")
    public void iSelectSubscribeYesRadioButtonInRegisterPage() {
        new RegisterPage().clickOnSubscribeToNewsletter();
    }

    @And("I click on Privacy Policy check box in register page")
    public void iClickOnPrivacyPolicyCheckBoxInRegisterPage() {
        new RegisterPage().clickOnPrivacyPolicy();
    }

    @And("I click on Continue button for registration in register page")
    public void iClickOnContinueButtonForRegistrationInRegisterPage() {
        new RegisterPage().clickOnContinueAfterPrivacyButton();
    }

    @And("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedText) {
        Assert.assertEquals(new AccountCreationPage().getAccountCreationMessage(), expectedText);
    }

    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        new AccountCreationPage().clickOnContinueAfterAccountCreation();
    }

    @And("I click on My Account Link")
    public void iClickOnMyAccountLink() {
        new AccountPage().clickOnMyAccountLink();
    }

    @And("I should see the text after logout {string}")
    public void iShouldSeeTheTextAfterLogout(String expectedText) {
        Assert.assertEquals(new LogoutPage().getTextFromLogout(), expectedText);
    }

    @And("I Enter Email address {string} in login page")
    public void iEnterEmailAddressInLoginPage(String arg0) {
        new LoginPage().sendEmail("Dhyan@grr.la");
    }

    @And("I enter Password {string}")
    public void iEnterPassword(String pass) {
        new LoginPage().sendPassword(pass);
    }

    @And("I Click on Login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLogin();
    }

    @And("I should see the my account text {string}")
    public void iShouldSeeTheMyAccountText(String expectedText) {
        Assert.assertEquals(new AccountPage().getMyAccountText(), expectedText);
    }

    @And("I should see the text account logout {string} after logout")
    public void iShouldSeeTheTextAccountLogoutAfterLogout(String expectedText) {
        Assert.assertEquals(new LogoutPage().getTextFromLogout(), expectedText);
    }
}
