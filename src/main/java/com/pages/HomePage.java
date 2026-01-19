package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.base.CommonToAllPage;


/**
 * HomePage - Page Object Model class for Shady Meadows B&B homepage
 * 
 * This class handles all interactions with the hotel booking interface including
 * date selection, room type selection, and availability checking. It serves as the
 * entry point for all booking scenarios.
 * 
 * @author Febil_Jose_Babu
 *
 * Responsibilities:
 * - Manage date selection (check-in/check-out)
 * - Handle room type selection (Single, Double, Suite)
 * - Process availability checks
 */

public class HomePage extends CommonToAllPage{
	
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Element locators
	private By checkIn = By.xpath("(//div[@class='react-datepicker__input-container'])[1]/input");
	private By checkOut = By.xpath("(//div[@class='react-datepicker__input-container'])[2]/input");
	private By checkAvailBtn = By.xpath("//button[text()='Check Availability']");
	private By singleBookNowBtn = By.xpath("(//a[text()='Book now'])[1]");
	private By doubleBookNowBtn = By.xpath("(//a[text()='Book now'])[2]");
	private By suiteBookNowBtn = By.xpath("(//a[text()='Book now'])[3]");
	
	//page actions
	//Enter CheckIn Date Method using Actions class.
	public void enterCheckInDate(String date) {
		scrollAndClick(checkIn);
		
		new Actions(driver)
        	.keyDown(Keys.COMMAND)
	        .sendKeys("a")
	        .keyUp(Keys.COMMAND)
	        .sendKeys(Keys.BACK_SPACE)
	        .sendKeys(date)
	        .build()
	        .perform();
	}
	
	//Enter Check-Out Date Method using Actions class.
	public void enterCheckOutDate(String date) {
		scrollAndClick(checkOut);
		
	    new Actions(driver)
	        .keyDown(Keys.COMMAND)
	        .sendKeys("a")
	        .keyUp(Keys.COMMAND)
	        .sendKeys(Keys.BACK_SPACE)
	        .sendKeys(date)
	        .build()
	        .perform();
	}
	
	public void checkAvailability() {
		scrollAndClick(checkAvailBtn); 
	}
	
	public void bookSingleRoom() {
		scrollAndClick(singleBookNowBtn);
	}
	public void bookDoubleRoom() {
		scrollAndClick(doubleBookNowBtn);
	}
	
	public void bookSuiteRoom(){
		scrollAndClick(suiteBookNowBtn);
	}
	
	
	/* Future enhancement: Implement edge case handling for room booking
	public void bookDoubleRoom() {
		
		//old one
//		try {
//            // Try to click double room button
//            clickElement(doubleBookNowBtn);
//        } catch (StaleElementReferenceException e) {
//            // If element is stale, re-find and retry
//            System.out.println("Double room button was stale, re-finding...");
//            WebElement freshDoubleBtn = getDriver().findElement(doubleBookNowBtn);
//            freshDoubleBtn.click();
//        }
		
		//new one
		try {
	        // Try to click double room button
			// Check if "Double" room exists before booking
	        WebElement doubleRoomElement = getDriver().findElement(doubleRoomTitle);
	        // If we reach here, room exists - proceed to book
	        
	        // Simple if statement to verify room type
	        if (doubleRoomElement.isDisplayed()) {
	            // Room exists, click book button
	            clickElement(doubleBookNowBtn);
	            System.out.println("Double room booked successfully");
	        } else {
	            System.out.println("Double room not displayed");
	            handleRoomNotAvailable("Double");
	        }
	        
	    } catch (StaleElementReferenceException e) {
	        // If element is stale, re-find and retry
	        System.out.println("Double room button was stale, re-finding...");
	        WebElement freshDoubleBtn = getDriver().findElement(doubleBookNowBtn);
	        freshDoubleBtn.click();
	        
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        // If element not found, room is not available
	        System.out.println(" No double room available for selected dates");
	        System.out.println("Please change dates and try again");
	        getDriver().quit(); // Close browser
	        throw new RuntimeException("Double room not available"); // Stop test
	    }
	}
	*/
//	public void bookDoubleRoom() {
//	    try {
//	    	WebElement doubleRoomElement = getDriver().findElement(doubleRoomTitle);
//            String roomText = doubleRoomElement.getText();
//            
//            if ("Double".equals(roomText)) {
//                // Step 2: Room exists, now try to book
//                clickElement(doubleBookNowBtn);
//                System.out.println("Double room booking initiated");
//            } else {
//                System.out.println("Room type mismatch: " + roomText);
//                handleRoomNotAvailable("Double");
//            }           
//	    } catch (StaleElementReferenceException e) {
//	        // Handle stale book button
//	        System.out.println("Double room button was stale, re-finding...");
//	        WebElement freshDoubleBtn = getDriver().findElement(doubleBookNowBtn);
//	        freshDoubleBtn.click();
//	        
//	    } catch (org.openqa.selenium.NoSuchElementException e) {
//	        // Double room title element not found
//	        System.out.println("No double room available for selected dates");
//	        handleRoomNotAvailable("Double");
//	    }
//	}

//	private void handleRoomNotAvailable(String roomType) {
//	    System.out.println("💡 Please change dates and try again");
//	    getDriver().quit();
//	    throw new RuntimeException(roomType + " room not available");
//	}
}