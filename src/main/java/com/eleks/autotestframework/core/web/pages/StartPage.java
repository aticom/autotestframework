package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Button;
import com.eleks.autotestframework.core.web.elements.TextInput;

public class StartPage extends Webpage<StartPage>{

	public StartPage(WebDriver driver) {
		super(driver);
		
	}

	private final static String PAGE_URL= BASE_URL + "/lvivatglance.org.ua";
	//private final static String PAGE_URL= "http://atico-design.com/lvivatglance.org.ua/user/login";
	
	@Override
	public StartPage load() {
		driver.get(PAGE_URL);
		return null;
	}

	@Override
	public boolean isAvailable() {
		
		return true;
	}
	
	
	///////////////////ne robocha storinka
	

}
