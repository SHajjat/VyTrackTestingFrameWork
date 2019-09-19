package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
	private Driver() {}
	
	private static WebDriver driver;
	private static String browser = ConfigurationReader.get("browser");
	
	public synchronized static WebDriver get() {
		if ( driver == null ) {
			switch (browser.toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "chromheadless":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "firefoxheadless":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
				
				case "ie":
					if ( System.getProperty("os.name").toLowerCase().equals("mac") ) {
						throw new WebDriverException("Mac is not compatible with Internet Explorer");
					}
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;
				case "edge":
					if ( System.getProperty("os.name").toLowerCase().equals("mac") ) {
						throw new WebDriverException("Mac is not compatible with Edge");
					}
				case "safari":
					if ( System.getProperty("os.name").toLowerCase().equals("windows") ) {
						throw new WebDriverException("Windows is not compatible with Safari ");
					}
					driver = new SafariDriver();
					break;
				
			}
			
		}
		return driver;
	}
	
	public static void terminate() {
		if ( driver != null ) {
			driver.quit();
			driver = null;
		}
	}
}
