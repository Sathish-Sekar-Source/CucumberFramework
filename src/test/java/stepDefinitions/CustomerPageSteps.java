package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.CustomerPage;

import java.util.Objects;

public class CustomerPageSteps extends BaseClass {

    @When("I click on Customers menu")
    public void i_click_on_customers_menu() {
        customerPage = new CustomerPage(driver);
        customerPage.clickOnCustomersMenu();
    }

    @When("I click on Customers menu item")
    public void i_click_on_customers_menu_item() {
        customerPage.clickOnCustomersMenuItem();
    }

    @Then("I verify customer page title is {string}")
    public void i_verify_customer_page_title_is(String string) {
        if (string.contains(customerPage.getPageTitle())) {
            Assert.assertTrue("", true);
        } else {
            driver.quit();
            Assert.fail();
        }
    }

    @When("I click on Add new button")
    public void i_click_on_add_new_button() {
        customerPage.clickOnAddNew();
    }

    @Then("Verify Add new customer page title is {string}")
    public void verify_add_new_customer_page_title_is(String string) {
        System.out.println("Actual Title: " + customerPage.getPageTitle());
        if (Objects.equals(string, customerPage.getPageTitle())) {
            Assert.assertTrue("User navigate into Add new Customer Page Successfully", true);
        } else {
            driver.quit();
            Assert.fail();
        }
    }

    @When("I enter customer info set company {string} newsletter {string} customerRoles {string} vendor {string} and adminComment {string}")
    public void i_enter_customer_info(String company, String newsLetter,
                                      String customerRoles, String vendor, String adminComment) {
        customerPage.enterCustomerInfo(company, newsLetter, customerRoles, vendor, adminComment);
    }

    @When("I click on save button")
    public void i_click_on_save_button() {
        customerPage.clickOnSave();
    }

    @Then("I verify success message is displayed as {string}")
    public void i_verify_success_message_is_displayed_as(String string){
        String actualMessage = customerPage.getCreateMessage();
        System.out.println("ActualMessage "+actualMessage);
        if (actualMessage.contains(string)) {
            Assert.assertTrue("User Add new Customer Successfully", true);
        } else {
            driver.quit();
            Assert.fail();
        }
    }

    // Search Customer by Email
    @When("Enter Customer Search Detail {string} {string} {string}")
    public void enter_customer_email(String email, String firstName, String lastName) {
//        customerPage.clickOnSearch();
        customerPage.enterSearchEmail(email,firstName,lastName);
    }
    @When("Click on search button")
    public void click_on_search_button() {
        customerPage.clickOnSearchButton();
    }
    @Then("User should found Email in the search table {string}")
    public void user_should_found_email_in_the_search_table(String email) throws InterruptedException {
        customerPage.searchResultTableDetails(email);
    }

}
