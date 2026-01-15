package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Task1_DoubleRoom {
	
	WebDriver driver;
	
	@Given("User on the Shady Meadows B&B booking website")
	public void user_on_the_shady_meadows_b_b_booking_website() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://automationintesting.online/");
		driver.manage().window().maximize();
	}
	
	@When("User clicks Check-in Date")
	public void user_clicks_checkin_date() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Combine waiting, locating, and scrolling in one sequence
		WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("(//div[@class='react-datepicker__input-container'])[1]/input")));

		// Single Actions chain for better performance
		new Actions(driver)
		    .moveToElement(checkin)  // Scroll to element
		    .click(checkin)          // Click in one fluent action
		    .keyDown(Keys.COMMAND)
		    .sendKeys("a")
		    .keyUp(Keys.COMMAND)
		    .sendKeys(Keys.BACK_SPACE)
		    .sendKeys("16/01/2026")
		    .build()
		    .perform();
	}
	
	@And("User clicks Check-Out Date")
	public void user_clicks_check_out_date() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Combine waiting, locating, and scrolling in one sequence
		WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("(//div[@class='react-datepicker__input-container'])[2]/input")));

		// Single Actions chain for better performance
		new Actions(driver)
		    .moveToElement(checkin)  // Scroll to element
		    .click(checkin)          // Click in one fluent action
		    .keyDown(Keys.COMMAND)
		    .sendKeys("a")
		    .keyUp(Keys.COMMAND)
		    .sendKeys(Keys.BACK_SPACE)
		    .sendKeys("18/01/2026")
		    .build()
		    .perform();
	}
	
	@And("User clicks Check Availability button")
	public void user_clicks_check_availability_button() {
		WebElement checkAvailBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
 				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Check Availability']")));
				
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", checkAvailBtn);
	}

	@Then("Double Room type from available options should be Selected")
	public void double_room_type_from_available_options_should_be_selected() {
 		WebElement bookButton = new WebDriverWait(driver, Duration.ofSeconds(10))
 				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Book now'])[2]")));
			        
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", bookButton);
	}
	
	@And("User clicks the Reserve Now button")
	public void user_clicks_the_reserve_now_button() {
		WebElement reserveNow = new WebDriverWait(driver, Duration.ofSeconds(10))
 				.until(ExpectedConditions.elementToBeClickable(By.id("doReservation")));
		
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", reserveNow);
	}

	@And("User fill the required field and clicks Reserve Now button")
	public void user_fill_the_required_field_and_clicks_reserve_now_button() {
		
		
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='Firstname']"));
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", firstName);
				
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Lastname']"));
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
		WebElement reserveNow = driver.findElement(By.xpath("//button[text()='Reserve Now']"));
		
		firstName.sendKeys("Nathaniel");
		lastName.sendKeys("Alexander");
		email.sendKeys("nathaniel@gmail.com");
		phone.sendKeys("87764572572");
		reserveNow.click();
	}

	@Then("Booking Confirmed Message is Displayed")
	public void booking_confirmed_message_is_displayed(){
		
		String expectedMsg = "Booking Confirmed";
		String actualMsg = driver.findElement(By.xpath("//h2[text()='Booking Confirmed']")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
}