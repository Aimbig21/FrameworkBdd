package stepDefs;


	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class MakeMyTripStepDefs {

	    WebDriver driver;

	    @Given("User is on the MakeMyTrip homepage")
	    public void user_is_on_the_make_my_trip_homepage() throws InterruptedException {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.makemytrip.com/");
	        Thread.sleep(3000); // Wait for login to complete
	    }

	    @When("User logs in with username {string} and password {string}")
	    public void user_logs_in_with_username_and_password(String username, String password) throws InterruptedException {
	    	
		        driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	    }

	    @When("User searches for a flight from {string} to {string} for tomorrow's date")
	    public void user_searches_for_a_flight_from_to_for_tomorrows_date(String fromCity, String toCity) throws InterruptedException {
	        // Select "From" city
	        driver.findElement(By.id("fromCity")).click();
	        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("HYD");
	        driver.findElement(By.xpath("//p[contains(text(),'" + fromCity + "')]")).click();

	        // Select "To" city
	        driver.findElement(By.id("toCity")).click();
	        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("RJY");
	        driver.findElement(By.xpath("//p[contains(text(),'" + toCity + "')]")).click();

	        // Select tomorrow's date
	        LocalDate tomorrow = LocalDate.now().plusDays(1);
	        String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
	        driver.findElement(By.xpath("//div[@aria-label='" + formattedDate + "']")).click();

	        // Search for flights
	        driver.findElement(By.cssSelector("a.widgetSearchBtn")).click();
	        Thread.sleep(5000); // Wait for the results to load
	    }

	    @When("User selects an Indigo flight")
	    public void user_selects_an_indigo_flight() throws InterruptedException {
	        // Filter for Indigo flights
	        driver.findElement(By.xpath("//span[text()='IndiGo']")).click();
	        Thread.sleep(2000);

	        // Select the first available Indigo flight
	        List<WebElement> flights = driver.findElements(By.cssSelector("button.bookNow"));
	        if (flights.isEmpty()) {
	            throw new RuntimeException("No Indigo flights available");
	        }
	        flights.get(0).click();
	        Thread.sleep(3000); // Wait for the booking page to load
	    }

	    @Then("User proceeds to the checkout page")
	    public void user_proceeds_to_the_checkout_page() throws InterruptedException {
	        // Click on continue to proceed to the checkout page
	        driver.findElement(By.cssSelector("button.checkoutBtn")).click();
	        Thread.sleep(3000); // Wait for the checkout page to load
	    }

	    @Then("User grabs the text from the checkout page")
	    public void user_grabs_the_text_from_the_checkout_page() {
	        // Grab and print text from the checkout page
	        WebElement checkoutText = driver.findElement(By.cssSelector("div.checkoutSummary"));
	        String text = checkoutText.getText();
	        System.out.println("Checkout Page Text: " + text);

	        // Example assertion (replace with actual expected text if needed)
	        Assert.assertTrue(text.contains("Passenger"), "Checkout page text does not contain passenger information!");

	        // Close the browser
	        driver.quit();
	    }
	}



