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