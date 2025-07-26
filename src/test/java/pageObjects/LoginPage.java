package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        return loginPageTitle.getText();
    }

    public String getLoginPageError() {
        return txtLoginPageError.getText();
    }

}
