package com.eleks.autotestframework.core.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.eleks.autotestframework.core.Environment;
import com.eleks.autotestframework.core.web.Webpage;
import com.eleks.autotestframework.core.web.elements.Button;
import com.eleks.autotestframework.core.web.elements.Link;
import com.eleks.autotestframework.core.web.elements.Text;
import com.eleks.autotestframework.core.web.elements.TextInput;

import static com.eleks.autotestframework.core.Configuration.getConfig;

public class CreateUserPage extends Webpage<CreateUserPage>{

	public CreateUserPage(WebDriver driver) {
		super(driver);
		
	}

	
	private final static String PAGE_URL= BASE_URL + "/lvivatglance.org.ua/admin/user/user/create";
	
	
	@Override
	public CreateUserPage load() {
		driver.get(PAGE_URL);
		return null;
	}

	@Override
	public boolean isAvailable() {
		
		return getCreateNewAccountButton().isAvailable() &&
				getUserNameInput().isAvailable() &&
				getEmailInput().isAvailable() &&
				getPasswordInput1().isAvailable()&&
				getPasswordInput2().isAvailable();
	}
	
	public CreateUserPage fillInForm(String userName, String password1, String password2, String email){
		
		getUserNameInput().inputText(userName);
		getEmailInput().inputText(email);
		getPasswordInput1().inputText(password1);
		getPasswordInput2().inputText(password2);
		//getCreateNewAccountButton().click(); vruchnu klikajemo inshym metodom
		
		return this;
	}
	
	public String getPageErrorMessage(){
		
		return new Text(driver, By.xpath("//div[contains(@class, 'messages error')]/ul/li")).getText();
	}
	
	public CreateUserPage submitFormExpectingError(){
		getCreateNewAccountButton().click();
		return this.waitUntilAvailable();
	}
	
	private TextInput getUserNameInput(){
		return new TextInput(driver, By.id("edit-name"));
	}
	
	
	private TextInput getEmailInput(){
		return new TextInput(driver, By.id("edit-mail"));
	}
	
	private TextInput getPasswordInput1(){
		return new TextInput(driver, By.id("edit-pass-pass1"));
	}
	
	private TextInput getPasswordInput2(){
		return new TextInput(driver, By.id("edit-pass-pass2"));
	}
	
	private Button getCreateNewAccountButton(){
		return new Button(driver, By.id("edit-submit"));
	}
	
	//
	public void logoutUser(){
		getLogOutLinkEND().click();
		
	}
	
	public Link getLogOutLinkEND(){
		return new Link(driver, By.xpath("//a[contains(@href, '/logout')]"));
	}

}
