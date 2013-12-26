package com.eleks.autotestframework.core;

import static com.eleks.autotestframework.core.DriverMaster.getDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import static com.eleks.autotestframework.core.Configuration.setGlobalEnvironment;

public abstract class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({"browser", "environment"})
	public void setUp(@Optional("firefox") String browser, @Optional("local") String environment){
		
		driver = getDriver(browser);
		setGlobalEnvironment(environment);
		
		
		/*if (browser.equals("firefox")){
			driver = new FirefoxDriver();
		}
		else if (browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "D:\\Javapractise\\selenium-webdriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Javapractise\\selenium-webdriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			driver = new FirefoxDriver();			
		}*/
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown(){
		
		driver.quit();
	}

}
