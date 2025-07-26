Feature: Login

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

  @smokeTest
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