package com.main.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.freecrm.qa.base.TestBaseFreeCRM;

public class LoginPage extends TestBaseFreeCRM {

	/* This is the object repository for the login page */

	/* Page Factory[Object Repository] for login Page */

	/* We are going to use @FindBy annotations to define all the page elements */

	@FindBy(xpath = "//input[@name = \"email\"]")
	static WebElement emailAdd;

	@FindBy(xpath = "//input[@name = \"password\"]")
	static WebElement password;

	@FindBy(xpath = "//div[@Class = \"ui fluid large blue submit button\" and contains(text(),\"Login\")]")
	static WebElement loginBtn;

	@FindBy(linkText = "Forgot your password?")
	static WebElement frgtPwd;

	@FindBy(linkText = "Classic CRM")
	static WebElement classicLink;

	@FindBy(linkText = "Sign Up")
	static WebElement signUpLink;

	@FindBy(xpath = "//div[@Class = \"onesignal-bell-launcher-button\"]")
	static WebElement notificationIcon;

	/* we need to initialize the webElements with the driver object */

	public LoginPage() {
		PageFactory.initElements(driverObj, this);
	}

	/* Create the features available for the login page */

	public  String fetchTitle() {

		// To get the title of the page
		return driverObj.getTitle();

	}

	public boolean isNotificDisplayed() {
		// To check whether the element passed is displayed
		return notificationIcon.isDisplayed();

	}

	public  ForgotPasswordPage forgotPassword() {

		LoginPage.frgtPwd.click();

		return new ForgotPasswordPage();
	}

	public  ClassicCRMPage classicCRM() {
		classicLink.click();
		return new ClassicCRMPage();
	}

	public  SignUpPage signUp() {
		signUpLink.click();
		return new SignUpPage();
	}

	public  HomePage login(String eid, String pwd) {
		emailAdd.sendKeys(eid);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();
	}

}
