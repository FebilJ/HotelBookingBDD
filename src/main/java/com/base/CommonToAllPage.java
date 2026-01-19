package com.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
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
	
	//Clicks on an element after waiting until it becomes clickable
	public void clickWithWait(By by) {
	    WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(by));
	    element.click();
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