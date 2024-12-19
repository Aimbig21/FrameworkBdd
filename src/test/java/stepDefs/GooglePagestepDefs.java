package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class GooglePagestepDefs {

    WebDriver driver;
    @Given("User is on the Google homepage")
    public void user_is_on_the_google_homepage() {
        // Navigate to Google homepage
    	driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("User enters a search keyword {string} in the search box")
    public void user_enters_a_search_keyword_in_the_search_box(String keyword) {
        // Find the search box and enter the search keyword
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium java");
        searchBox.submit();  // Alternatively, you can click the search button instead
    }

    @When("User presses the search button")
    public void user_presses_the_search_button() {
        // Click on the search button (optional if you submit the form in the previous step)
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
    }

    @Then("The search results should be displayed")
    public void the_search_results_should_be_displayed() {
        // Use WebDriverWait to wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement results = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

        // Verify if the results are displayed
        Assert.assertTrue("Search results are not displayed!", results.isDisplayed());
    }
}
