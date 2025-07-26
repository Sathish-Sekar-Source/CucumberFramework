package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.AddCustomerPage;

import java.util.Objects;

public class AddCustomerPageSteps extends BaseClass {

    @When("I click on Customers menu")
    public void i_click_on_customers_menu() {
        addCustomerPage = new AddCustomerPage(driver1);
        addCustomerPage.clickOnCustomersMenu();
    }

    @When("I click on Customers menu item")
    public void i_click_on_customers_menu_item() {
        addCustomerPage.clickOnCustomersMenuItem();
    }

    @Then("I verify customer page title is {string}")
    public void i_verify_customer_page_title_is(String string) {
        if (string.contains(addCustomerPage.getPageTitle())) {
            Assert.assertTrue("", true);
        } else {
            driver1.quit();
            Assert.fail();
        }
    }

    @When("I click on Add new button")
    public void i_click_on_add_new_button() {
        addCustomerPage.clickOnAddNew();
    }

    @Then("Verify Add new customer page title is {string}")
    public void verify_add_new_customer_page_title_is(String string) {
        System.out.println("Actual Title: " + addCustomerPage.getPageTitle());
        if (Objects.equals(string, addCustomerPage.getPageTitle())) {
            Assert.assertTrue("User navigate into Add new Customer Page Successfully", true);
        } else {
            driver1.quit();
            Assert.fail();
        }
    }

    @When("I enter customer info set company {string} newsletter {string} customerRoles {string} vendor {string} and adminComment {string}")
    public void i_enter_customer_info(String company, String newsLetter,
                                      String customerRoles, String vendor, String adminComment) {
        addCustomerPage.enterCustomerInfo(company, newsLetter, customerRoles, vendor, adminComment);
    }

    @When("I click on save button")
    public void i_click_on_save_button() {
        addCustomerPage.clickOnSave();
    }

    @Then("I verify success message is displayed as {string}")
    public void i_verify_success_message_is_displayed_as(String string) throws InterruptedException {
        Thread.sleep(2000);
        String actualMessage = addCustomerPage.getCreateMessage();
        System.out.println("ActualMessage "+actualMessage);
        if (actualMessage.contains(string)) {
            Assert.assertTrue("User Add new Customer Successfully", true);
        } else {
            driver1.quit();
            Assert.fail();
        }
    }
}
