package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.Environment;
import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Button;
import com.eleks.autotestframework.core.web.elements.CheckBox;
import com.eleks.autotestframework.core.web.elements.DropDownList;
import com.eleks.autotestframework.core.web.elements.Link;
import com.eleks.autotestframework.core.web.elements.RadioButton;

import static com.eleks.autotestframework.core.Configuration.getConfig;

public class UsersPage extends Webpage<UsersPage> {

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
	
	//
	public UsersPage deleteUser () throws InterruptedException{
		Thread.sleep(2000);
		getFirstUserCheckBox().click();
		Thread.sleep(2000);
		getDropDownList().choose("delete");
		Thread.sleep(2000);
		getUpdateButton().click();
		getDeleteButton().click();
		return new UsersPage(driver).waitUntilAvailable();
	}
	
	//to do continue
	private CheckBox getFirstUserCheckBox(){
		return new CheckBox(driver, By.xpath(".//*[@id='user-admin-account']/div/table[2]/tbody/tr[1]/td[1]/div[1]/label/input[1]"));
	}
	
	private DropDownList getDropDownList(){
		return new DropDownList(driver, By.xpath("id('edit-operation')"));
	}
	//
	private Button getUpdateButton(){
		return new Button(driver, By.xpath("id('edit-submit-1')"));
	}
	
	private Button getDeleteButton(){
		return new Button(driver, By.xpath("id('edit-submit')"));
	}

}
