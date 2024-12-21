package runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
    features = "src/test/resources/features//",
    glue = {"stepDefs"}, // Path to the step definition package
    monochrome=true,
    plugin = {
        "pretty", 
        "html:target/cucumber-reports",        // Generates HTML report
    }
        )
public class ParallelRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
 
  }

}