package com.eleks.autotestframework.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eleks.autotestframework.core.BaseTest;
import com.eleks.autotestframework.core.CsvDataProvider;
import com.eleks.autotestframework.core.web.pages.AdminHomePage;
import com.eleks.autotestframework.core.web.pages.AdministerPage;
import com.eleks.autotestframework.core.web.pages.CreateUserPage;
import com.eleks.autotestframework.core.web.pages.LoginPage;
import com.eleks.autotestframework.core.web.pages.UsersPage;


public class SecondTest extends BaseTest {
	
	
	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void verifyFailedBlockedUserCreationErrorMessage(Map<String, String> testData) throws InterruptedException {
		
		
		
		CreateUserPage targetPage =  new AdminHomePage(driver).loadAsAnonymousUser().loginAs(testData.get("admin_username"), testData.get("admin_password"))
		.goToAdministerPage().goToUserManagementPage().goToUsersPage().goToCreateUserPage().fillInFormWithBlockedUser(testData.get("username"), testData.get("password1"), testData.get("password2"), testData.get("email"))
		.submitFormExpectingError();
		
		//CreateUserPage targetPage =  new AdminHomePage(driver).loadAsAnonymousUser().loginAs("lvivatglance", "paroldo ekaunta")
		//.goToAdministerPage().goToUserManagementPage().goToUsersPage().goToCreateUserPage().fillInForm("selenium", "qwerty", "qwerty", "email@mail.com")
		//.submitFormExpectingError(); //my zaminyly na dani jaki my tiagnemo z csv failu
		
		assertThat("Page message should be as expected", targetPage.getPageMessageStatus(), is(equalTo(testData.get("error_message"))));
		
		//--------------------------------------toDO----
		 targetPage.goToUsersPage().deleteUser();
		
		//Thread.sleep(5000);
		
		//targetPage.logoutUser();
		
		//new AdminHomePage(driver).getAirlinesLink().click();
		//Thread.sleep(5000);
		//new AdminHomePage(driver).getLogOutLink().click();
		//Thread.sleep(5000);		
	}	
	
	@AfterMethod(alwaysRun = true)
	public void logoutUser(){
		new CreateUserPage(driver).logoutUser();
		//new LoginPage(driver).waitUntilAvailable();
	}
		
}
