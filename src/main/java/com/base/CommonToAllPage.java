package com.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.PropertiesReader;
import com.drivers.DriverManager;

/**
 * CommonToAllPage - Base class providing common Selenium utility methods
 * 
 * This abstract class serves as the foundation for all page object classes,
 * providing reusable methods for common web element interactions, waits,
 * and browser operations. All page classes should extend this class.
 * 
 * @author Febil_Jose_Babu
 * 
 * Features:
 * - Comprehensive wait strategies (explicit and implicit)
 * - JavaScript execution capabilities
 * - Scroll and click operations
 * - Element location and interaction methods
 * - Configuration-based URL navigation
 */

public class CommonToAllPage {
	
	//WebDriver instance from DriverManager
	protected WebDriver getDriver() {
	    return DriverManager.getDriver();
	}
	
    //Launches the Shady Meadows B&B application
    //Uses URL from properties file for configuration-based navigation
	public void launchShadyMeadows(){
		getDriver().get(PropertiesReader.readKey("url"));
	}
	
	
	/* 
	 * -------------------Waits Methods----------------------
	*/
	
	//explicit wait
	public  WebDriverWait getWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	//Implicit(static) wait
	public void custom_wait(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	
	//Wait for element, scroll to center, and returns it for Dates
	protected WebElement waitAndScroll(By locator) throws InterruptedException {
	    WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(locator));
	    
	    ((JavascriptExecutor) getDriver()).executeScript(
	        "arguments[0].scrollIntoView({block: 'center'});", element);
	    
	    Thread.sleep(500);
	    return element;
	}
	
	//Clicks on an element after waiting until it becomes clickable
	public void clickWithWait(By by) {
	    WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(by));
	    element.click();
	}
	
	/* 
	 * -------------------Clear Date TextBox----------------------
	*/
	
	//Clear field using COMMAND+A Delete and type text
	protected  void clearAndType(String text) {
	    new Actions(getDriver())
	        .keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND)
	        .sendKeys(Keys.DELETE)
	        .sendKeys(text)
	        .perform();
	}
	
    //Scroll to top of page
    public void scrollToTop() {
        ((JavascriptExecutor) getDriver()).executeScript(
            "window.scrollTo(0, 0);");
    }
	
	//Scrolls to a specific element and performs click using JavaScript
	public void scrollAndClick(By by) {
	    WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(by));
	    
	    // Scroll to element first
	    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    
	    // Then click using JavaScript
	    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Scrolls element into view with center alignment
	 */
	public void scrollToView(By by) {
	    WebElement element = getDriver().findElement(by);
	    ((JavascriptExecutor) getDriver()).executeScript(
	        "arguments[0].scrollIntoView({block: 'center'});", 
	        element
	    );
	}
	
	//Waits until the element is visible on the page
	public WebElement waitForVisibility(By locator) {
	    return new WebDriverWait(getDriver(), Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Clicks on an element using By locator (no explicit wait)
	public void clickElement(By by) {
		getDriver().findElement(by).click();
    }
	
	//Clicks on a WebElement directly
    public void clickElement(WebElement by) {
        by.click();
    }
    
    //Enters text into an input field using By locator
    public void enterInput(By by, String key){ 
    	getDriver().findElement(by).sendKeys(key); 
    } 
    
    // Enters text into an input field using WebElement
    public void enterInput(WebElement by, String key){
    	by.sendKeys(key); 
    }
    
    //Retrieves text from an element using By locator
    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    //Retrieves text from a WebElement
    public String getText(WebElement by){
        return by.getText();
    }
}