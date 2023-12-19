@regression
Feature: Top Menu Feature
  In Order to perform topmenu test
  As a User
  I have to verify that user should navigate to the corresponding page

  @author_Hiren_Italia @sanity @smoke
  Scenario Outline: User should navigate to desktops page successfully
    Given I am on homepage
    When I mouse hover and click on topmenu options "<menutab>"
    And I mouse hover and click on topmenu sub options "<submenutab>"
    Then I should navigate to corresponding page successfully and verify the page heading "<pageheading>"
    Examples:
      | menutab             |  | submenutab                   |  | pageheading         |
      | Desktops            |  | Show All Desktops            |  | Desktops            |
      | Laptops & Notebooks |  | Show All Laptops & Notebooks |  | Laptops & Notebooks |
      | Components          |  | Show All Components          |  | Components          |


