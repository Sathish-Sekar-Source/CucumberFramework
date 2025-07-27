package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class LoginPageSteps extends BaseClass {

    @Before
    public void setUp() throws IOException {
        logger = Logger.getLogger("Project Name");
        PropertyConfigurator.configure("log4j.properties");

        configProperties=new Properties();
        FileInputStream configPropertiesFile=new FileInputStream("config.properties");
        configProperties.load(configPropertiesFile);

        String browser = configProperties.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + configProperties.getProperty("chrome_driver_path"));
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + configProperties.getProperty("firefox_driver_path"));
            driver = new FirefoxDriver();
        }
        logger.info("******Browser launched successfully******");

    }

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        loginPage = new LoginPage(driver);
        BaseClass.driver1 = driver;
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
            Assert.assertEquals(string, loginPage.getHomePageTitle());
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

    @And("close the browser")
    public void close_the_browser() {
        driver.quit();
    }

}
