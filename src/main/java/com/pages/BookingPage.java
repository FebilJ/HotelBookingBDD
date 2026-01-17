package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.CommonToAllPage;
import static com.drivers.DriverManager.getDriver;

public class BookingPage extends CommonToAllPage{

	private WebDriver driver;
	
	//Constructor
	public BookingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	private By firstReserveNowBtn = By.id("doReservation");
	private By firstNameTxt = By.xpath("//input[@placeholder='Firstname']");
	private By lastNameTxt = By.xpath("//input[@placeholder='Lastname']");
	private By emailTxt = By.xpath("//input[@placeholder='Email']");
	private By phoneTxt = By.xpath("//input[@placeholder='Phone']");
	private By secondReserveNowBtn = By.xpath("//button[text()='Reserve Now']");
	private By confirmationMessage = By.xpath("//h2[text()='Booking Confirmed']");
	
	//page actions
	public void ClickFirstReserveNow(){
		scrollAndClick(firstReserveNowBtn);
	}
	
	public void fillGuestDetailsAndReserve(String firstName, String lastName, String email, String phone) {
	    enterInput(firstNameTxt, firstName);
	    enterInput(lastNameTxt, lastName);
	    enterInput(emailTxt, email);
	    enterInput(phoneTxt, phone);
	    clickElement(secondReserveNowBtn);
	}
	
	// Method to get confirmation text
    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
    
    // Method to check if confirmation is displayed
    public boolean isConfirmationDisplayed() {
        return getDriver().findElement(confirmationMessage).isDisplayed();
    }
}