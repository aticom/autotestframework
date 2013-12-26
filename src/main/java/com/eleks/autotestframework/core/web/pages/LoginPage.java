package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Button;
import com.eleks.autotestframework.core.web.elements.TextInput;

public class LoginPage extends Webpage<LoginPage>{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	private final static String PAGE_URL= BASE_URL + "/lvivatglance.org.ua/user/login";
	//private final static String PAGE_URL= "http://atico-design.com/lvivatglance.org.ua/user/login";
	
	@Override
	public LoginPage load() {
		driver.get(PAGE_URL);
		return null;
	}

	@Override
	public boolean isAvailable() {
		
		return getUserNameInput().isAvailable() && getPasswordInput().isAvailable();
	}
	
	public AdminHomePage loginAs(String username, String password){
		
		getUserNameInput().inputText(username);
		getPasswordInput().inputText(password);
		getLoginButton().click();
		return new AdminHomePage(driver).waitUntilAvailable();
	}
	
	private TextInput getUserNameInput(){
		return new TextInput(driver, By.id("edit-name"));
	}
	
	private TextInput getPasswordInput(){
		return new TextInput(driver, By.id("edit-pass"));
	}
	
	private Button getLoginButton(){
		return new Button(driver, By.id("edit-submit"));
	}

}
