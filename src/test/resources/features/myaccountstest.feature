@regression
Feature: My Account Test
  In Order to perform my account features
  As a User
  I should navigate to register page successfully
  I should navigate to login page successfully
  I should register account successfully
  I should login and logout successfully

  @sanity @smoke
  Scenario: Verify User Should Navigate To Register Page Successfully
    Given I am on homepage
    When I click on My Account tab
    And I call the method selectMyAccountOptions method and pass the parameter "Register"
    Then I should see text as register account "Register Account"

  @smoke
  Scenario: Verify User Should Navigate To LoginPage Successfully
    Given I am on homepage
    When I click on My Account tab
    And I call the method selectMyAccountOptions method and pass the parameter "Login"
    Then I should see text as returning customer "Returning Customer"

  @regression
  Scenario: Verify That User Register Account Successfully
    Given I am on homepage
    When I click on My Account tab
    And I call the method selectMyAccountOptions method and pass the parameter "Register"
    And I enter First Name "Dhyan" in register page
    And I enter Last Name "Magn" in register page
    And I enter Email "Dhyan@grr.la" in register page
    And I enter Telephone "01234345555" in register page
    And I enter Password "HellNone" in register page
    And I enter Confirm Password "HellNone" in register page
    And I select Subscribe Yes radio button in register page
    And I click on Privacy Policy check box in register page
    And I click on Continue button for registration in register page
    And I should see the message "Your Account Has Been Created!"
    And I click on Continue button
    And I click on My Account Link
    And I call the method selectMyAccountOptions method and pass the parameter "Logout"
    And I should see the text after logout "Account Logout"
    Then I click on Continue button

  @regression
  Scenario: Verify That User Should Login And Logout
    Given I am on homepage
    When I click on My Account tab
    And I call the method selectMyAccountOptions method and pass the parameter "Login"
    And I Enter Email address "Dhyan@grr.la" in login page
    And I enter Password "HellNone"
    And I Click on Login button
    And I should see the my account text "My Account"
    And I click on My Account Link
    And I call the method selectMyAccountOptions method and pass the parameter "Logout"
    And I should see the text account logout "Account Logout" after logout
    Then I click on Continue button

