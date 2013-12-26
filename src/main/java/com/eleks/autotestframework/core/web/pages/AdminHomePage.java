package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.Configuration;
import com.eleks.autotestframework.core.Environment;
import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Link;

import static com.eleks.autotestframework.core.Configuration.getConfig;

public class AdminHomePage extends Webpage<AdminHomePage>{

	public AdminHomePage(WebDriver driver) {
		super(driver);
		
	}

	
	private final static String PAGE_URL= BASE_URL + "/lvivatglance.org.ua/users/lvivatglance";
	//private final static String PAGE_URL= "http://atico-design.com/lvivatglance.org.ua/users/lvivatglance"; //admin  -te scho zverkhu my zaminyly i perenesly v Webpage.java
	
	@Override
	public AdminHomePage load() {
		driver.get(PAGE_URL);
		return null;
	}

	@Override
	public boolean isAvailable() {
		
		return getAdministerLink().isAvailable();
	}
	
	public LoginPage loadAsAnonymousUser(){
		//load(); //u nas ne tak
		driver.get(BASE_URL + "/lvivatglance.org.ua/user/login");   // , a tak
		return new LoginPage(driver).waitUntilAvailable();
	}
	
	
	public AdministerPage goToAdministerPage(){
		getAdministerLink().click();
		return new AdministerPage(driver).waitUntilAvailable();
		
	}
	
	
	
	private Link getAdministerLink(){
		return new Link(driver, By.xpath("//a[contains(@href, '/admin')]"));
	}
	
	public Link getLogOutLink(){
		return new Link(driver, By.xpath("//a[contains(@href, '/logout')]"));
	}
	
	public Link getAirlinesLink(){
		return new Link(driver, By.xpath("//a[contains(@href, '/airlines')]"));
	}
	
	//
	

}
