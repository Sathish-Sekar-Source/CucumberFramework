package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMSteps {

    WebDriver driver;
//
//    @Given("I launch chrome browser")
//    public void i_launch_chrome_browser() {
//        System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver2/chromedriver.exe");
//        driver = new ChromeDriver();
//    }
//
//    @When("I open the OrangeHRM home page")
//    public void i_open_the_orange_hrm_home_page() {
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    }
//
//    @Then("I verify that logo is present on the page")
//    public void i_verify_that_logo_is_present_on_the_page() throws InterruptedException {
//        Thread.sleep(2000);
//        boolean status= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
//        Assert.assertTrue(status);
//    }
//
//    @And("close the browser")
//    public void close_the_browser() {
//        driver.close();
//    }
}
