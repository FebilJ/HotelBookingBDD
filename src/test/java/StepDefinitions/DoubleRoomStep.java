package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.pages.*;
import com.base.CommonToAllPage;
import com.drivers.DriverManager;
import static org.testng.Assert.assertTrue;

public class DoubleRoomStep extends CommonToAllPage{
	
	
	private HomePage homePage;
	private BookingPage bookingPage; 
	
	//constructor
	public DoubleRoomStep() {
        homePage = new HomePage(DriverManager.getDriver());
        bookingPage = new BookingPage(DriverManager.getDriver()); 
    }
	
	@Given("User on the Shady Meadows B&B")
	public void user_on_the_shady_meadows_b_b() {
		launchShadyMeadows();
	}
	
	@When("User clicks Check-in date as {string}")
	public void user_clicks_check_in_date_as(String chekInDate) {
		homePage.enterCheckInDate(chekInDate);   
	}
	@And("User clicks Check-Out date as {string}")
	public void user_clicks_check_out_date_as(String checkOutDate) {
		homePage.enterCheckOutDate(checkOutDate);
	}
	@And("User clicks Check Availability button")
	public void user_clicks_check_availability_button() {
		homePage.checkAvailability();
	}
	
	@Then("Select Room Type Double")
	public void select_room_type_double() {
	    homePage.bookDoubleRoom();
	}

	@And("User clicks the Reserve Now button")
	public void user_clicks_the_reserve_now_button() {
		bookingPage.ClickFirstReserveNow();
	}
	
	@And("User enters details as {string} {string} {string} {string}")
	public void user_enters_details_as(String firstName, String lastName, String email, String phone){
		bookingPage.fillGuestDetailsAndReserve(firstName, lastName, email, phone);
	}

	@Then("Booking Confirmed Message is Displayed")
	public void booking_confirmed_message_is_displayed() {
		  // Wait for confirmation to appear
	    try {
	        Thread.sleep(2000); // Wait 2 seconds for page to load
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
//		// Method 1: Check if message is displayed
//        assertTrue(bookingPage.isConfirmationDisplayed(), 
//                   "Booking confirmation message should be displayed");
        
        // Method 2: Verify the exact message text
        String actualMessage = bookingPage.getConfirmationMessage();
        assertTrue(actualMessage.contains("Booking Confirmed"), 
                   "Expected 'Booking Confirmed' message but got: " + actualMessage);
        System.out.println("============================");
        System.out.println(actualMessage);
        System.out.println("============================");
    }

}