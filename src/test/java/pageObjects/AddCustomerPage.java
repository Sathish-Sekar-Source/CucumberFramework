package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static stepDefinitions.BaseClass.*;

public class AddCustomerPage {
    public WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By lnkCustomers_menu = By.xpath("//*/p[normalize-space(.)='Customers']/i");
    By lnkCustomers_menuItem = By.xpath("(//*/p[normalize-space(.)='Customers'])[2]");
    By btnAddNew = By.xpath("//*[normalize-space(.)='Add new']");
    By txtCustomerTitle = By.xpath("//div[@class='content-header clearfix']/h1");
    By txtEmail = By.id("Email");
    By txtPassword = By.id("Password");
    By txtFirstName = By.id("FirstName");
    By txtLastName = By.id("LastName");
    By radioGender_Male = By.id("Gender_Male");
    By txtCompany = By.id("Company");
    By chkIsTaxExempt = By.id("IsTaxExempt");
    By txtNewsLetter = By.xpath("(//*[text()='Newsletter']/following::div//*[@class='selection'])[1]");
    By txtCustomerRoles = By.xpath("(//*[text()='Customer roles']/following::div//*[@class='selection'])[1]");
    By selectVendor = By.xpath("//select[@id='VendorId']");
    By txtAdminComment = By.id("AdminComment");
    By btnSaveForm = By.xpath("//button[@name='save']");
    By txtCreateMessage = By.xpath("//div[@class='alert alert-success alert-dismissable']");

    public void clickOnCustomersMenu() {
        driver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomersMenuItem() {
        driver.findElement(lnkCustomers_menuItem).click();
    }

    public void clickOnAddNew() {
        driver.findElement(btnAddNew).click();
    }

    public String getPageTitle() {
        return driver.findElement(txtCustomerTitle).getText().trim();
    }

    public void setEmail(String email) {
        driver.findElement(txtEmail).clear();
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void setFirstName(String firstName) {
        driver.findElement(txtFirstName).clear();
        driver.findElement(txtFirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(txtLastName).clear();
        driver.findElement(txtLastName).sendKeys(lastName);
    }

    public void setGenderMale() {
        if (!driver.findElement(radioGender_Male).isSelected()) {
            driver.findElement(radioGender_Male).click();
        }
    }

    public void setCompany(String company) {
        driver.findElement(txtCompany).clear();
        driver.findElement(txtCompany).sendKeys(company);
    }

    public void setIsTaxExempt() {
        if (!driver.findElement(chkIsTaxExempt).isSelected()) {
            driver.findElement(chkIsTaxExempt).click();
        }
    }

    public void setNewsLetter(String newsLetter) {
        driver.findElement(txtNewsLetter).click();
        driver.findElement(By.xpath("//li[contains(text(),'" + newsLetter + "')]")).click();
    }

    public void setCustomerRoles(String customerRoles) {
        driver.findElement(txtCustomerRoles).click();
        driver.findElement(By.xpath("//li[contains(text(),'" + customerRoles + "')]")).click();
    }

    public void setVendor(String vendor) {
        Select vendorSelect = new Select(driver.findElement(selectVendor));
        vendorSelect.selectByVisibleText(vendor);
    }

    public void setAdminComment(String adminComment) {
        driver.findElement(txtAdminComment).clear();
        driver.findElement(txtAdminComment).sendKeys(adminComment);
    }

    public void clickOnSave() {
        driver.findElement(btnSaveForm).click();
    }

    public void enterCustomerInfo(String company, String newsLetter,
                                  String customerRoles, String vendor, String adminComment) {
        setEmail(generateEmail("gmail.com"));
        setPassword(generatePassword(12));
        setFirstName(getRandomFirstName());
        setLastName(getRandomLastName());
        setGenderMale();
        setCompany(company);
        setIsTaxExempt();
        setNewsLetter(newsLetter);
        setCustomerRoles(customerRoles);
        setVendor(vendor);
        setAdminComment(adminComment);
    }

    public String getCreateMessage() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(txtCreateMessage).getText().trim();
    }

}
