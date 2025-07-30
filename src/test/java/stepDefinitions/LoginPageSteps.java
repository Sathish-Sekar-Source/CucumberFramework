package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;

import java.util.Objects;

public class LoginPageSteps extends BaseClass {

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
    }

    @When("I open opens URL {string} home page")
    public void i_open_opens_url_home_page(String string) {
        logger.info("******Launching URL: " + string + "******");
        driver.get(string);
    }

    @When("I enter Email as {string}")
    public void i_enter_email_as(String string) {
        loginPage.setUserName(string);
    }

    @When("I enter Password as {string}")
    public void i_enter_password_as(String string) {
        loginPage.setPassword(string);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I verify home page title is {string}")
    public void i_verify_home_page_title_is(String string) {
        if (Objects.requireNonNull(driver.getPageSource()).contains("Login was unsuccessful")) {
            driver.quit();
            Assert.fail();
        } else {
            //Assert.assertEquals(string, loginPage.getHomePageTitle());
            System.out.println("title is: " + driver.getTitle());
            Assert.assertEquals(string, driver.getTitle());
        }
    }

    @When("I click on Logout button")
    public void i_click_on_logout_button() {
        loginPage.clickLogout();
    }

    @Then("I verify login page title is {string}")
    public void i_verify_login_page_title_is(String string) {
        if (string.contains(loginPage.getLoginPageTitle())) {
            Assert.assertTrue("Login Out redirect into login page successfully", true);
        } else {
            driver.quit();
            Assert.fail("Login page title is not as expected");
        }
    }

    @Then("I verify error message is displayed as {string}")
    public void i_verify_error_message_is_displayed_as(String string) {
        String actualErrorMessage = loginPage.getLoginPageError();
        System.out.println("Actual Error Message: " + actualErrorMessage);
        if (actualErrorMessage.contains(string)) {
            Assert.assertTrue("Login page display valid error message successfully", true);
        } else {
            driver.quit();
            Assert.fail("Login page not displayed valid error message" + string + " but actual is " + actualErrorMessage);
        }
    }

    @Then("I enter search text as {string}")
    public void i_enter_search_text_as(String string) {
        loginPage.enterSearchText(string);
    }
    @Then("I click on the search button")
    public void i_click_on_the_search_button() {
        loginPage.clickSearch();
    }
    @Then("I verify search results page title contains {string}")
    public void i_verify_search_results_page_title_contains(String string) {
        loginPage.verifyPageElementIsDisplayed(string);
    }

    @And("close the browser")
    public void close_the_browser() {
        driver.quit();
    }

}
