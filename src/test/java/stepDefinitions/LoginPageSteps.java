package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.util.Objects;

public class LoginPageSteps {

    public WebDriver driver;
    LoginPage loginPage;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
//        driver.manage().window().maximize();
    }

    @When("I open opens URL {string} home page")
    public void i_open_opens_url_home_page(String string) {
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
        if(Objects.requireNonNull(driver.getPageSource()).contains("Login was unsuccessful")) {
            driver.quit();
            Assert.fail();
        }else {
            Assert.assertEquals(string, loginPage.getHomePageTitle());
        }
    }

    @When("I click on Logout button")
    public void i_click_on_logout_button() {
        loginPage.clickLogout();
    }

    @Then("I verify login page title is {string}")
    public void i_verify_login_page_title_is(String string) throws InterruptedException {
        Thread.sleep(3000);
        if (string.contains(loginPage.getLoginPageTitle())){
            Assert.assertTrue("Login Out redirect into login page successfully",true);
        }else{
            driver.quit();
            Assert.fail("Login page title is not as expected");
        }
    }

    @And("close the browser")
    public void close_the_browser() {
        driver.quit();
    }

}
