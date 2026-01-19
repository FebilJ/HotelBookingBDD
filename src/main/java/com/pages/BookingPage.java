package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.base.CommonToAllPage;


/**
 * BookingPage - Page Object Model class for handling hotel booking confirmation page
 * 
 * This class contains all the elements and actions related to the booking confirmation
 * of guest details form and final reservation.
 * 
 * @author Febil_Jose_Babu
 * 
 * Responsibilities:
 * - Handle guest information form filling
 * - Process final reservation submission
 * - Verify booking confirmation messages
 */


public class BookingPage extends CommonToAllPage{

	private WebDriver driver;
	
	//Constructor
	public BookingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Element locators
	private By firstReserveNowBtn = By.id("doReservation");
	private By firstNameTxt = By.xpath("//input[@placeholder='Firstname']");
	private By lastNameTxt = By.xpath("//input[@placeholder='Lastname']");
	private By emailTxt = By.xpath("//input[@placeholder='Email']");
	private By phoneTxt = By.xpath("//input[@placeholder='Phone']");
	private By secondReserveNowBtn = By.xpath("//button[text()='Reserve Now']");
	private By confirmationMessage = By.xpath("//h2[text()='Booking Confirmed']");
	
	/**
    * Reserve selected room and proceed to guest details
    */
	public void ClickFirstReserveNow(){
		scrollAndClick(firstReserveNowBtn);
	}
	
	/**
    * Complete guest information and finalize booking
    */
	public void fillGuestDetailsAndReserve(String firstName, String lastName, String email, String phone) {
	    enterInput(firstNameTxt, firstName);
	    enterInput(lastNameTxt, lastName);
	    enterInput(emailTxt, email);
	    enterInput(phoneTxt, phone);
	    clickElement(secondReserveNowBtn);
	}
	
	/**
     * Get booking confirmation message text
     */
    public String getConfirmationMessage() {
        scrollToTop();
        return waitForVisibility(confirmationMessage).getText();
    }
}