
//in progress !!!!!!!!!!!!!!!!!!!!
package com.eleks.autotestframework.core.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.eleks.autotestframework.core.web.WebComponent;

public class DropDownList extends WebComponent<DropDownList>{

	public DropDownList(WebDriver driver, By findByMethod) {
		super(driver, findByMethod);
		
	}
	
	public void choose(String name){
		
		Select clickThis = new Select(this.getWebElement()); 
		clickThis.selectByValue(name); 
	}

	

}
