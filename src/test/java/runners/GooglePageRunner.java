package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/MakeMyTrip.feature", // Correct path separator
    glue = {"stepDefs"}, // Path to the step definition package
    monochrome=true,
    plugin = {
        "pretty", 
        "html:target/cucumber-reports",        // Generates HTML report
        "rerun:target/failedScenaios.txt"
//        "usage:target/Usagereport",            // Generates usage report
//        "json:target/JsonReport.json",         // Corrected JSON plugin path
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  // Extent Reports integration?
    }
)
public class GooglePageRunner extends AbstractTestNGCucumberTests {
    // No additional methods needed as AbstractTestNGCucumberTests takes care of the test execution
}
