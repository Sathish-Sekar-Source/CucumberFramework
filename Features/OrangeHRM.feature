Feature: OrangeHRM Login

  Scenario: Logo presence on OrangeHRM home page
    Given I launch chrome browser
    When I open the OrangeHRM home page
    Then I verify that logo is present on the page
    And close the browser
