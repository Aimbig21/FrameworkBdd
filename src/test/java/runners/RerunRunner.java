package runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "@target/failedScenaios.txt", // Correct path separator
	    glue = {"stepDefs"}, // Path to the step definition package
	    monochrome=true
	    )
	   
public class RerunRunner extends AbstractTestNGCucumberTests {
 
  }

