@regression
Feature: verifyProductArrangeInAlphaBaticalOrder

  @author_Hiren_Italia @sanity @smoke
  Scenario: verify Product Arrange In AlphaBatical Order
    Given I am on homepage
    When I mouse hover and click on topmenu options "Desktops"
    And I mouse hover and click on topmenu sub options "Show All Desktops"
    Then I select sort by name Z to A "Name (Z - A)"

  @author_Hiren_Italia @smoke
  Scenario Outline: Verify Product Added To Shopping Cart SuccessFully
    Given I am on homepage
    When I click on currency and select GBP
    And I mouse hover and click on topmenu options "Desktops"
    And I mouse hover and click on topmenu sub options "Show All Desktops"
    And I select sort by name A to Z "Name (A - Z)"
    And I select product "<product>"
    And I should see the product text "<product>"
    And I enter Qty to one "1"
    And I click on Add to Cart button
    And I should see the success message Success: You have added "<product>" to your shopping cart!
    And I click on shopping cart link into success message
    And I should see the shopping text
    And I should see the product name "<product>"
    And I should see the model "<model>"
    Then I should see the total "<price>"
    Examples:
      | product      | model      | price   |
      | HTC Touch HD | Product 1  | £74.73  |
      | iPhone       | product 11 | £75.46  |
      | iPod Classic | product 20 | £74.73  |
      | MacBook      | Product 16 | £368.73 |
      | MacBook Air  | Product 17 | £736.23 |
      | Sony VAIO    | Product 19 | £736.23 |