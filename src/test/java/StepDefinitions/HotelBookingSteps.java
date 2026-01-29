package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.pages.*;
import com.base.CommonToAllPage;
import com.drivers.DriverManager;
import static org.testng.Assert.assertTrue;

/**
 * HotelBookingSteps - Cucumber Step Definitions for Hotel Booking Feature
 * 
 * This class contains all the Step Definitions that map Gherkin steps to Java code
 * for the hotel booking automation scenarios, where it handles the complete booking flow
 * from navigation to confirmation.
 * 
 * @author Febil_Jose_Babu
 * 
 * Features:
 * - Flexible step matching for natural language variations
 * - Page Object Model integration
 * - Parameterized step definitions
 */

public class HotelBookingSteps extends CommonToAllPage{ 
	private HomePage homePage;
	private BookingPage bookingPage; 
	
	//constructors
	public HotelBookingSteps() {
        homePage = new HomePage(DriverManager.getDriver());
        bookingPage = new BookingPage(DriverManager.getDriver()); 
    }
	
	//launching the Web-site
	@Given("User on the Shady Meadows B&B")
	public void user_on_the_shady_meadows_b_b() {
		launchShadyMeadows();
	}

	//==================== DATE SELECTION STEPS ====================
    /**
     * Handles all variations of check-in date selection steps
     * Supports multiple natural language patterns for flexibility
     * 
     * @param checkInDate Check-in date in "DD/MM/YYYY" format
     * @throws Exception 
     * @throws InterruptedException 
     */
    @When("User clicks Check-in date as {string}")
    @When("User selects check-in date as {string}")
    @When("User chooses check-in date as {string}")
    @When("User Clicks check-in date as {string}")
    public void process_check_in_date(String checkInDate) throws Exception{
        homePage.enterCheckInDate(checkInDate);   
    }
    
    /**
    * Handles all variations of check-out date selection steps
    * Provides flexibility for different team member writing styles
    * 
    * @param checkOutDate Check-out date in "DD/MM/YYYY" format
     * @throws Exception 
    */
    @And("User clicks Check-Out date as {string}")
    @And("User selects check-out date as {string}")
    @And("User chooses check-out date as {string}")
    @And("User Clicks check-out date as {string}")
    public void process_check_out_date(String checkOutDate) throws Exception {
        homePage.enterCheckOutDate(checkOutDate);
    }
    
    //==================== AVAILABILITY CHECK STEP ====================
    /**
     * Triggers the room availability check for selected dates
     * Waits for the system to process and display available rooms
     */
	@And("User clicks Check Availability button")
	public void user_clicks_check_availability_button() {
		homePage.checkAvailability();
	}
	
	//==================== ROOM SELECTION STEP ====================
    /**
     * Selects the specified room type with case-insensitive matching
     * Supports multiple step wording variations for flexibility
     * 
     * @param roomType Room type to select ("DOUBLE", "SUITE", or "SINGLE")
     */
	@Then("Select Room Type {string}")
	@Then("Choose Room Type {string}")
	@Then("Book Room Type {string}")
	public void select_room_type(String roomType) {
	    switch(roomType.toUpperCase()) {
	        case "DOUBLE":
	            homePage.bookDoubleRoom();
	            System.out.println("Double room selected");
	            break;
	        case "SUITE":
	            homePage.bookSuiteRoom();
	            System.out.println("Suite room selected");
	            break;
	        case "SINGLE":
	            homePage.bookSingleRoom();
	            System.out.println("Single room selected");
	            break;
	        default:
	            throw new RuntimeException("Unknown room type: " + roomType);
	    }
	}
	
	@And("User clicks the Reserve Now button")
	public void user_clicks_the_reserve_now_button() {
		bookingPage.ClickFirstReserveNow();
	}
	
	//==================== ENTER GUEST DETAILS ====================
	/**
     * Fills guest details and completes the reservation
     * 
     * @param firstName Guest's first name
     * @param lastName Guest's last name
     * @param email Guest's email address
     * @param phone Guest's phone number
     */  
	@And("User enters details as {string} {string} {string} {string}")
	@And("User enters guest details for {string} {string} {string} {string}")
	public void enter_guest_details(String firstName, String lastName, String email, String phone) {
	    bookingPage.fillGuestDetailsAndReserve(firstName, lastName, email, phone);
	}
	
	//Verifies that the booking confirmation message is displayed
	@Then("Booking Confirmed Message is Displayed")
	public void booking_confirmed_message_is_displayed() {
	    String actualMessage = bookingPage.getConfirmationMessage();

	    assertTrue(actualMessage.contains("Booking Confirmed"),
	            "Expected 'Booking Confirmed' message but got: " + actualMessage);

	    System.out.println("============================");
	    System.out.println(actualMessage);
	    System.out.println("============================");
	}
}