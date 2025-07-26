Feature: Customers

  @smokeTest1
  Scenario: Add new customer with valid details
    Given I launch chrome browser
    When I open opens URL "https://admin-demo.nopcommerce.com/login" home page
    And I enter Email as "admin@yourstore.com"
    And I enter Password as "admin"
    And I click on the login button
    Then I verify home page title is "Dashboard"
    When I click on Customers menu
    And I click on Customers menu item
    Then I verify customer page title is "Customers"
    And I click on Add new button
    Then Verify Add new customer page title is "Add a new customer back to customer list"
    When I enter customer info set company "TCS" newsletter "nopCommerce admin demo store" customerRoles "Administrators" vendor "Vendor 2" and adminComment "Test user creation"
    And I click on save button
    Then I verify success message is displayed as "The new customer has been added successfully"
    And close the browser
