package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html",
                "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false,
        tags = "@GoogleTest" // You can change or remove this line to run all tests
)
public class TestRunner {


}
