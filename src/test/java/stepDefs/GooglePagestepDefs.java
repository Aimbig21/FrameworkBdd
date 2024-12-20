package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class GooglePagestepDefs {

    WebDriver driver;

    @Given("User is on the Google homepage")
    public void user_is_on_the_google_homepage() {
        // Set up the WebDriver (use your ChromeDriver path)
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @When("User enters the search keyword {string} in the search box")
    public void user_enters_the_search_keyword_in_the_search_box(String keyword) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword);
        searchBox.submit(); // Simulates pressing Enter
    }

    @Then("the entered text should be {string}")
    public void the_entered_text_should_be(String expectedText) {
        WebElement searchBox = driver.findElement(By.name("q"));
        String actualText = searchBox.getAttribute("value");
        Assert.assertEquals("The entered text is incorrect!", expectedText, actualText);

        // Close the browser after validation
        driver.quit();
    }
}
