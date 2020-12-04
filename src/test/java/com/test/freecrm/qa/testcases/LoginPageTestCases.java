package com.test.freecrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.freecrm.qa.base.TestBaseFreeCRM;
import com.main.freecrm.qa.pages.ClassicCRMPage;
import com.main.freecrm.qa.pages.ForgotPasswordPage;
import com.main.freecrm.qa.pages.HomePage;
import com.main.freecrm.qa.pages.LoginPage;
import com.main.freecrm.qa.pages.SignUpPage;

public class LoginPageTestCases extends TestBaseFreeCRM {

	/* Create the objeect of login page */

	public static LoginPage loginPageObj;
	public static ClassicCRMPage ClassicCRMPageobj;
	public static SignUpPage SignUpPageObj;
	public static HomePage HomePageObj;
	public static ForgotPasswordPage ForgotPasswordPageObj;

	/* call the base class constructor from the child class using the super(); */

	public LoginPageTestCases() throws IOException {
		super();
	}

	/* This is the test class for the Login Page */
	/* WE ARE USING TESTNG ANNOTATIONS FOR WRITTING THE TEST CASES */

	@BeforeMethod
	public static void setup() {
		init();
		loginPageObj = new LoginPage();
	}

	@Test(priority = 1)
	public void TitleTest() {
		String PageTitle = loginPageObj.fetchTitle();
		Assert.assertEquals(PageTitle, "Cogmento CRM");
	}

	@Test(priority = 2)
	public void notificationIconIsDisplayedTest() {
		boolean isDis = loginPageObj.isNotificDisplayed();
		Assert.assertTrue(isDis);
	}

	@Test(priority = 3)
	public void forgotPasswordTest() {
		ForgotPasswordPageObj = loginPageObj.forgotPassword();
	}

	@Test(priority = 4)
	public void classicCRMTest() {
		ClassicCRMPageobj = loginPageObj.classicCRM();
	}

	@Test(priority = 5)
	public void signUpTest() {
		SignUpPageObj = loginPageObj.signUp();
	}

	@Test(priority = 6)
	public void loginTest() {

		HomePageObj = loginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public static void tearDown() {
		driverObj.quit();
	}

}
