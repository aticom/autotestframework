package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.Environment;
import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Link;

import static com.eleks.autotestframework.core.Configuration.getConfig;

public class UsersPage extends Webpage<UsersPage>{

	public UsersPage(WebDriver driver) {
		super(driver);
		
	}

	
	private final static String PAGE_URL= BASE_URL + "/lvivatglance.org.ua/admin/user/user";
	
	
	@Override
	public UsersPage load() {
		driver.get(PAGE_URL);
		return null;
	}

	@Override
	public boolean isAvailable() {
		
		return getCreateUserLink().isAvailable();
	}
	
	public CreateUserPage goToCreateUserPage(){
		getCreateUserLink().click();
		return new CreateUserPage(driver).waitUntilAvailable();
	}
	
	
	private Link getCreateUserLink(){
		return new Link(driver, By.xpath("//a[contains(@href, '/user/create')]"));
	}
	
	

}
