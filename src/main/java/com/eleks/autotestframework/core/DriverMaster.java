package com.eleks.autotestframework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverMaster {

	private DriverMaster(){}
	
	public static WebDriver getDriver(String driverKey){
	
		BrowserType browser = BrowserType.get(driverKey);
		WebDriver driver;
		switch (browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
				
			case IE:
				System.setProperty("webdriver.ie.driver", "D:\\Javapractise\\selenium-webdriver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
				
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "D:\\Javapractise\\selenium-webdriver\\chromedriver.exe");
				driver = new ChromeDriver();
				break;

			default:
				driver = new FirefoxDriver();
				break;
		}
				
		return driver;
	}
	
}
