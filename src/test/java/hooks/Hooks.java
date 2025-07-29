package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Connection;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + configProperties.getProperty("firefox_driver_path"));
            driver = new FirefoxDriver();
        }
        logger.info("******Browser launched successfully******");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("❌ Scenario Failed: " + scenario.getName());
            // Optionally take screenshot
        } else {
            System.out.println("✅ Scenario Passed: " + scenario.getName());
        }

    }
}
