package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class LoginPage {
    public WebDriver driver;
    public WaitHelper waitHelper;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper= new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[@class='page-title']")
    @CacheLookup
    WebElement loginPageTitle;

    @FindBy(xpath = "//div[contains(@class,'message-error')]")
    @CacheLookup
    WebElement txtLoginPageError;

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='content-header']/h1")
    @CacheLookup
    WebElement homePageTitle;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    @CacheLookup
    WebElement btnLogout;

    @FindBy(xpath = "//*[@title='Search']")
    @CacheLookup
    WebElement txtSearch;

    @FindBy(xpath = "(//*[@value='Google Search'])[2]")
    @CacheLookup
    WebElement btnSearch;

    public void setUserName(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String getHomePageTitle() {
        return homePageTitle.getText();
    }

    public void clickLogout() {
        btnLogout.click();
    }

    public String getLoginPageTitle() {
        waitHelper.waitForElement(loginPageTitle,10);
        return loginPageTitle.getText();
    }

    public String getLoginPageError() {
        waitHelper.waitForElement(txtLoginPageError,10);
        return txtLoginPageError.getText();
    }

    public void enterSearchText(String searchText) {
        txtSearch.clear();
        txtSearch.sendKeys(searchText);
        txtSearch.sendKeys(Keys.ENTER);
    }

    public void clickSearch() {
        btnSearch.click();
    }

    public void verifyPageElementIsDisplayed(String title) {
        WebElement element = driver.findElement(By.xpath("(//*[text()='" + title + "'])[1]"));
        waitHelper.waitForElement(element, 5);
        if (element.isDisplayed()) {
            System.out.println("Element is displayed: " + element.toString());
            Assert.assertTrue(true);
        } else {
            System.out.println("Element is NOT displayed: " + element.toString());
            Assert.fail();
        }
    }

}
