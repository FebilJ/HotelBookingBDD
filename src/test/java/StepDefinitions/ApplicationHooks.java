package StepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import com.drivers.DriverManager;

/**
 * ApplicationHooks - Cucumber hooks for test setup and teardown
 * 
 * This class contains @Before and @After hooks which are executed
 * before and after every scenario in the feature file.
 * 
 * Responsibilities:
 * - Initialize WebDriver before the test starts
 * - Close WebDriver after the test ends
 * - Handles cleanup actions like waiting for a few seconds before closing
 * 
 * @author Febil_Jose_Babu
 */


public class ApplicationHooks {
	public static WebDriver driver;
	
	// Initializes the WebDriver using DriverManager.
	 @Before
    public void setUp(){
        DriverManager.init();
    }
	
	 //Closes the browser and releases resources.
    @After
    public void tearDown(){
        try{
             Thread.sleep(3000); // Wait 3 seconds before closing
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
        DriverManager.down();
    }
}