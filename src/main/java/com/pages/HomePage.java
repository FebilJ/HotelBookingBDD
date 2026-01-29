package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private By doubleTxt = By.xpath("//h5[text()='Double']");
	private By suiteBookNowBtn = By.xpath("(//a[text()='Book now'])[3]");
	
	//page actions
	//Enter CheckIn Date Method
	public void enterCheckInDate(String date) throws Exception {	  
		//Wait & Scroll for element to be ready & Click
		waitAndScroll(checkIn).click();
		clearAndType(date);
        System.out.println("✅ Check-in date entered: " + date);
	}
	
	//Enter CheckOut Date Method
	public void enterCheckOutDate(String date) throws Exception {
        // Wait & Scroll for element to be ready & Click
		waitAndScroll(checkOut).click();
		clearAndType(date);    
        System.out.println("✅ Check-out date entered: " + date);
	}
	
	public void checkAvailability() {
		scrollAndClick(checkAvailBtn); 
	}
	
	public void bookSingleRoom() {
		scrollAndClick(singleBookNowBtn);
	}
//	public void bookDoubleRoom() {
//		scrollAndClick(doubleBookNowBtn);
//	}
	
	public void bookDoubleRoom() {
	    try {
	        // Scroll to Double room section first
	    	WebElement doubleTxt = getDriver().findElement(By.xpath("//h5[text()='Double']"));
	    	String roomText = doubleTxt.getText();
	        
	    	// Check if it says "Double"
	        if ("Double".equals(roomText)) {
	        	scrollAndClick(doubleBookNowBtn);
	            System.out.println("✅ Double room is displayed");
	        } else {
	        	getDriver().quit();
	            throw new RuntimeException("Double room not available");
	        }
	        
	    }catch (Exception e){
	        System.out.printf("Exception---->", e);
	        getDriver().quit();
	        throw new RuntimeException("Double room not found", e);
	    }
	}
	
	public void bookSuiteRoom(){
		scrollAndClick(suiteBookNowBtn);
	}
	
	/* Future enhancement: Implement edge case handling for room booking
	*/
//	public void bookDoubleRoom() {
//	    try {
//	        // Check if "Double" room is displayed on the page
//	        By doubleRoomTitle = By.xpath("//h5[text()='Double']");
//	        WebElement doubleRoomElement = getDriver().findElement(doubleRoomTitle);
//	        
//	        if (doubleRoomElement.isDisplayed()) {
//	            // Double room is available - click the button
//	            clickElement(doubleBookNowBtn);
//	            System.out.println(" Double room booked successfully");
//	        } else {
//	            // Double room exists but not displayed (unlikely scenario)
//	            System.out.println("️ Double room element found but not visible");
//	            handleRoomNotAvailable("Double");
//	        }
//	        
//	    } catch (org.openqa.selenium.NoSuchElementException e) {
//	        // Double room not found on the page
//	        System.out.println(" No Double room available for selected dates");
//	        handleRoomNotAvailable("Double");
//	        
//	    } catch (StaleElementReferenceException e) {
//	        // Handle stale element - retry once
//	        System.out.println(" Double room button stale, retrying...");
//	        WebElement freshBtn = getDriver().findElement(doubleBookNowBtn);
//	        freshBtn.click();
//	    }
//	}
//
//	private void handleRoomNotAvailable(String roomType) {
//	    System.out.println(" " + roomType + " room is not available");
//	    System.out.println(" Please try different dates");
//	}
	
	//==================================================================
}