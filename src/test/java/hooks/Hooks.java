package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Connection;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import stepDefinitions.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends BaseClass {
    @Before
    public void setUp(Scenario scenario) throws IOException {
        System.out.println("🔧 Starting scenario: " + scenario.getName());
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
        else if(browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + configProperties.getProperty("ie_driver_path"));
            driver = new InternetExplorerDriver();
        }
        logger.info("******Browser launched successfully******");
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        test = extent.createTest("Sample Test");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("❌ Scenario Failed: " + scenario.getName());
            // Optionally take screenshot
        } else {
            System.out.println("✅ Scenario Passed: " + scenario.getName());
        }
        extent.flush(); // Generates the report

    }
}
