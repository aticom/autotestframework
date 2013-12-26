package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.Configuration;
import com.eleks.autotestframework.core.Environment;
import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Link;

import static com.eleks.autotestframework.core.Configuration.getConfig;

public class UserManagementPage extends Webpage<UserManagementPage>{

	public UserManagementPage(WebDriver driver) {
		super(driver);
		
	}

	
	private final static String PAGE_URL= BASE_URL + "/lvivatglance.org.ua/admin/user";
	
	
	@Override
	public UserManagementPage load() {
		driver.get(PAGE_URL);
		return null;
	}

	@Override
	public boolean isAvailable() {
		
		return getUsersLink().isAvailable();
	}
	
	
	
	
	public UsersPage goToUsersPage(){
		getUsersLink().click();
		return new UsersPage(driver).waitUntilAvailable();
	}
	
	
	
	public Link getUsersLink(){
		return new Link(driver, By.xpath("//a[contains(@href, '/admin/user/user')]"));
	}
	
	

}
