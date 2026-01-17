package com.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.PropertiesReader;

import static com.drivers.DriverManager.getDriver;

public class CommonToAllPage {
	
	//WebDriver driver;
	
	public void launchShadyMeadows(){
		getDriver().get(PropertiesReader.readKey("url"));
	}
	
	//explicit wait
	public  WebDriverWait getWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	//Implicit wait
	public void custom_wait(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void custom_wait2(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	
	//click with wait
	public void clickWithWait(By by) {
	    WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(by));
	    element.click();
	}
	
	//scroll & Click
	public void scrollAndClick(By by) {
	    WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(by));
	    
	    // Scroll to element first
	    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    
	    // Then click using JavaScript (more reliable)
	    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
	}

	
	public void clickElement(By by) {
        getDriver().findElement(by).click();
    }
	
    public void clickElement(WebElement by) {
        by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }
}