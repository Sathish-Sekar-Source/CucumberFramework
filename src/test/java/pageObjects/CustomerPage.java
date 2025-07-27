package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitHelper;

import java.util.Objects;

import static stepDefinitions.BaseClass.*;

public class CustomerPage {
    public WebDriver driver;
    public WaitHelper waitHelper;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
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
    By lnkSearch = By.xpath("//div[@class='row search-row']");
    By txtSearchEmail = By.id("SearchEmail");
    By txtSearchFirstName = By.id("SearchFirstName");
    By txtSearchLastName = By.id("SearchLastName");
    By btnSearch = By.id("search-customers");
    By eleSearchTable = By.xpath("//table[@id='customers-grid']");
    By eleSearchTableRows = By.xpath("//table[@id='customers-grid']//tbody/tr");
    By eleSearchTableColumns = By.xpath("//table[@id='customers-grid']//tbody/tr/td");

    int rows=0,
        columns=0;

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
        String email=generateEmail("gmail.com");
        setEmail(email);
        put("Email",email);
        String password = generatePassword(12);
        setPassword(password);
        put("Password", password);
        String firstName = getRandomFirstName();
        setFirstName(firstName);
        put("FirstName", firstName);
        String lastName = getRandomLastName();
        setLastName(lastName);
        put("LastName", lastName);
        setGenderMale();
        setCompany(company);
        setIsTaxExempt();
        setNewsLetter(newsLetter);
        setCustomerRoles(customerRoles);
        setVendor(vendor);
        setAdminComment(adminComment);
    }

    public String getCreateMessage() {
        waitHelper.waitForElement(driver.findElement(txtCreateMessage), 10);
        return driver.findElement(txtCreateMessage).getText().trim();
    }

    public void clickOnSearch() {
        waitHelper.waitForElement(driver.findElement(lnkSearch), 30);
        driver.findElement(lnkSearch).click();
    }

    public void enterSearchEmail(String email, String firstName, String lastName) {
        waitHelper.waitForElement(driver.findElement(txtSearchEmail), 10);
        driver.findElement(txtSearchEmail).clear();
        String Email = (!Objects.equals(email, "empty")) ? email : get("Email");
        driver.findElement(txtSearchEmail).sendKeys(Email);

        driver.findElement(txtSearchFirstName).clear();
        String FirstName = (!Objects.equals(firstName, "empty")) ? firstName : get("FirstName");
        driver.findElement(txtSearchFirstName).sendKeys(FirstName);

        driver.findElement(txtSearchLastName).clear();
        String LastName = (!Objects.equals(lastName, "empty")) ? lastName : get("LastName");
        driver.findElement(txtSearchLastName).sendKeys(LastName);
    }

    public void clickOnSearchButton() {
        driver.findElement(btnSearch).click();
    }

    public void searchResultTableDetails(String email) throws InterruptedException {
        waitHelper.waitForElement(driver.findElement(eleSearchTable), 30);
        rows = driver.findElements(eleSearchTableRows).size();
        columns = driver.findElements(eleSearchTableColumns).size();
        System.out.println("Total Rows: " + rows);
        System.out.println("Total Columns: " + columns);
        if (!Objects.equals(email, "empty")) {
            verifySearchResult(email);
        }else{
            verifySearchResult(get("Email"));
        }
    }

    public void verifySearchResult(String email) throws InterruptedException {
        boolean flag=false;
        String cellData="";
        Thread.sleep(1000);

        for (int i=1; i<=rows; i++) {
            for (int nxt=i+1;nxt<columns; nxt++) {
                cellData = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td["+nxt+"]")).getText();
                System.out.print(cellData + " | ");
                if (cellData.equals(email)) {
                    flag = true;
                    break;
                } else {
                    continue;
                }
            }
            if(flag) {
                clearRowAndColumnCount();
                break;
            }
        }
        if(flag) {
            System.out.println("Email found in the search table: " + cellData);
        }else{
            System.out.println("Email not found in the search table.");
            Assert.fail();
        }
    }

    public void clearRowAndColumnCount() {
        rows = 0;
        columns = 0;
    }

}
