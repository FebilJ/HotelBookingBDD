package com.drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.utils.PropertiesReader;

/**
 * DriverManager - Centralized WebDriver management class
 * 
 * This class is responsible for:
 * - Initializing WebDriver based on browser configuration
 * - Providing a globally accessible WebDriver instance
 * - Safely shutting down the browser after test execution
 * 
 * It follows a Singleton-like approach to ensure only one
 * WebDriver instance is active during execution.
 * 
 * @author Febil_Jose_Babu
 */

public class DriverManager {
	
	//Static WebDriver instance shared across the framework
	public static WebDriver driver;
	
	//Returns the active WebDriver instance
	public static WebDriver getDriver() {
		//return driver;
			
		if (driver == null) {
		     throw new IllegalStateException("WebDriver not initialized. Please check your @Before hooks.");
		 }
		return driver;
	}
	
	// Sets the WebDriver instance
	public static void setDriver(WebDriver driver) {
		DriverManager.driver = driver;
	}
	
	/**
     * Initializes the WebDriver based on browser value
     * read from the properties file
     * 
     * Supported browsers:
     * - chrome
     * - edge
     * - firefox
     */
	public static void init() {

        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        if(driver == null){
            switch (browser){
                case "edge" :
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    System.out.println("Not browser Found!!");
            }
        }
    }
    // Quits the browser and cleans up the WebDriver instance
    public static void down(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
	
}