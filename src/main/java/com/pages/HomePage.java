package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.CommonToAllPage;


public class HomePage extends CommonToAllPage{
	
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	private By checkIn = By.xpath("(//div[@class='react-datepicker__input-container'])[1]/input");
	private By checkOut = By.xpath("(//div[@class='react-datepicker__input-container'])[2]/input");
	private By checkAvailBtn = By.xpath("//button[text()='Check Availability']");
	private By singleBookNowBtn = By.xpath("(//a[text()='Book now'])[1]");
	private By doubleBookNowBtn = By.xpath("(//a[text()='Book now'])[2]");
	private By suiteBookNowBtn = By.xpath("(//a[text()='Book now'])[3]");
	
	//page actions
	public void enterCheckInDate(String date) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkInElement = wait.until(ExpectedConditions.elementToBeClickable(checkIn));
		
		new Actions(driver)
	    .scrollToElement(checkInElement)  // Scroll to element
	    .click(checkInElement)      
	    .keyDown(Keys.COMMAND)
	    .sendKeys("a")
	    .keyUp(Keys.COMMAND)
	    .sendKeys(Keys.BACK_SPACE)
	    .sendKeys(date)
	    .build()
	    .perform();
	}
	
	public void enterCheckOutDate(String date) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	     // First find the element
		 WebElement checkOutElement = wait.until(ExpectedConditions.elementToBeClickable(checkOut));
		
		new Actions(driver)
	    .scrollToElement(checkOutElement)  // Scroll to element
	    .click(checkOutElement)        
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
		WebElement singleBookNowBtnElement = driver.findElement(singleBookNowBtn);
		singleBookNowBtnElement.click();
	}
	
	public void bookDoubleRoom() {
		WebElement doubleBookNowBtnElement = driver.findElement(doubleBookNowBtn);
		//doubleBookNowBtnElement.click();
		
		// Scroll and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();", doubleBookNowBtnElement);
	}
	
	public void bookSuiteRoom() {
		WebElement suiteBookNowBtnElement = driver.findElement(suiteBookNowBtn);
		suiteBookNowBtnElement.click();
	}
}