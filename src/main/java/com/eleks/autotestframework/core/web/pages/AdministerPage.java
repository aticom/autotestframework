package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.Configuration;
import com.eleks.autotestframework.core.Environment;
import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Link;

import static com.eleks.autotestframework.core.Configuration.getConfig;

public class AdministerPage extends Webpage<AdministerPage>{

	public AdministerPage(WebDriver driver) {
		super(driver);
		
	}

	
	private final static String PAGE_URL= BASE_URL + "/lvivatglance.org.ua/admin";
	
	
	@Override
	public AdministerPage load() {
		driver.get(PAGE_URL);
		return null;
	}

	@Override
	public boolean isAvailable() {
		
		return getUserManagementLink().isAvailable();
	}
	
	public UserManagementPage goToUserManagementPage(){
		getUserManagementLink().click();
		return new UserManagementPage(driver).waitUntilAvailable();
		
	}
	
	private Link getUserManagementLink(){
		return new Link(driver, By.xpath("//a[contains(@href, '/admin/user')]"));
	}
	
	
	public Link getLogOutLink(){
		return new Link(driver, By.xpath("//a[contains(@href, '/logout')]"));
	}
	
	
	
	
	
	

}
