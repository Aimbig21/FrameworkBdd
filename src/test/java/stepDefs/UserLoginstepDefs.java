package stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginstepDefs {

	WebDriver driver;

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@When("User enters the credentilas")
	public void user_enters_the_credentilas() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
		driver.findElement(By.cssSelector("button.radius")).click();
	}

	@Then("shpuld dispaly the home page")
	public void shpuld_dispaly_the_home_page() {
		boolean isValidUser = driver.findElement(By.cssSelector("div.success")).isDisplayed();
		Assert.assertTrue(isValidUser);
	}



	@After

	    public void attachScreenshots(Scenario scenario) {
	        if (scenario.isFailed()) {
	            // Ensure driver is not null
	            if (driver != null) {
	                TakesScreenshot scr = (TakesScreenshot) driver;
	                byte[] img = scr.getScreenshotAs(OutputType.BYTES);
	                scenario.attach(img, "image/png", scenario.getName());
	    }
	}


	}}
	
	