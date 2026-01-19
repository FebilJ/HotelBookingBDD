package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesReader - Utility class to read values from properties file
 * 
 * This class provides a method to fetch configuration values
 * from the data.properties file located in the project resources.
 * 
 * It is used across the framework to read configuration values like:
 * - url
 * - browser
 * 
 * @author Febil_Jose_Babu
 */

public class PropertiesReader {
	
	//Reads the value of the specified key from the properties file.
	public static String readKey(String key){
		try {
	        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/resources/data.properties");
	        Properties p = new Properties();    														
	        p.load(fileInputStream);
	        return p.getProperty(key);
	    } catch (FileNotFoundException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}
}