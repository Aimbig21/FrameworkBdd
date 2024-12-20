package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src//test//resources//features//GooglePageSearch.feature",// Corrected path separator
    glue = {"stepDefs"}, // Path to the step definition package
    plugin = {"pretty", "html:target/cucumber-reports"}, // Optional: adds reports
    monochrome = true
    
)
public class GooglePageRunner extends AbstractTestNGCucumberTests {
    // No additional methods needed as AbstractTestNGCucumberTests takes care of the test execution
}
