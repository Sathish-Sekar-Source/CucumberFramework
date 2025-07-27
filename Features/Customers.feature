Feature: Customers

  Background:
    Given I launch chrome browser
    When I open opens URL "https://admin-demo.nopcommerce.com/login" home page
    And I enter Email as "admin@yourstore.com"
    And I enter Password as "admin"
    And I click on the login button
    Then I verify home page title is "Dashboard"

  @smokeTest1
  Scenario: Add new customer with Auto Generated details
    When I click on Customers menu
    And I click on Customers menu item
    Then I verify customer page title is "Customers"
    And I click on Add new button
    Then Verify Add new customer page title is "Add a new customer back to customer list"
    When I enter customer info set company "TCS" newsletter "nopCommerce admin demo store" customerRoles "Administrators" vendor "Vendor 2" and adminComment "Test user creation"
    And I click on save button
    Then I verify success message is displayed as "The new customer has been added successfully"
    And close the browser

  @smokeTest1
  Scenario: Search Existing Auto Generated Customer by empty EmailID, First Name, and Last Name
    When I click on Customers menu
    And I click on Customers menu item
    When Enter Customer Search Detail "empty" "empty" "empty"
    When Click on search button
    Then User should found Email in the search table "empty"
    And close the browser

  @smokeTest1
  Scenario: Search Existing Customer by EmailID, First Name, and Last Name
    When I click on Customers menu
    And I click on Customers menu item
    When Enter Customer Search Detail "admin@yourStore.com" "John" "Smith"
    When Click on search button
    Then User should found Email in the search table "admin@yourStore.com"
    And close the browser
