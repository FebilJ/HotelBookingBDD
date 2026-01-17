package StepDefinitions;

import org.openqa.selenium.WebDriver;

import com.drivers.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	public static WebDriver driver;
	
	 @Before
    public void setUp(){
        DriverManager.init();
    }

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