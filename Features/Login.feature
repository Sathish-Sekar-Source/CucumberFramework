Feature: Login

  @RegressionTest1
  Scenario: Successful login with valid credentials
    Given I launch chrome browser
    When I open opens URL "https://admin-demo.nopcommerce.com/login" home page
    And I enter Email as "admin@yourstore.com"
    And I enter Password as "admin"
    And I click on the login button
    Then I verify home page title is "Dashboard"
    When I click on Logout button
    Then I verify login page title is "Admin area demo"
    And close the browser

  @RegressionTest
  Scenario Outline: Login with invalid credentials
    Given I launch chrome browser
    When I open opens URL "https://admin-demo.nopcommerce.com/login" home page
    And I enter Email as "<email>"
    And I enter Password as "<password>"
    And I click on the login button
    Then I verify error message is displayed as "Login was unsuccessful. Please correct the errors and try again."
    And close the browser

    Examples:
      | email                | password   |
      | admin1@yourstore.com | admin      |
      | admin@yourstore.com  | admin1     |

  @GoogleTest
    Scenario: Login with empty credentials
    Given I launch chrome browser
    When I open opens URL "https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwi7gPrGueOOAxXISWwGHSnRMRYQPAgI" home page
    Then I verify home page title is "Google"
    And I enter search text as "Super Car"
    #And I click on the search button
    #Then I verify search results page title contains "AI Overview"
    And close the browser