package com.test.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.freecrm.qa.base.TestBaseFreeCRM;
import com.main.freecrm.qa.pages.ContactsPage;
import com.main.freecrm.qa.pages.HomePage;
import com.main.freecrm.qa.pages.LoginPage;
import com.main.freecrm.qa.util.TestUtil;

public class ContactPageTestCases extends TestBaseFreeCRM {

	public static LoginPage loginPageObj;
	public static HomePage HomePageObj;
	public static ContactsPage ContactPageObj;
	public static TestUtil TestUtilObj = new TestUtil();;

	public static String contact1 = "Rohan Sharma";
	public static String contact2 = "testUser user";

	public static String sheetName = "ContactPageData";

	/* This is the test case class for the Contact page */

	public ContactPageTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginPageObj = new LoginPage();
		HomePageObj = loginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));
		ContactPageObj = HomePageObj.clickContactslink();
	}

	@Test(priority = 1)
	public void contactsLabelDisplayed() {
		Assert.assertTrue(ContactPageObj.isContactsLabelDisplayed());
	}

	@Test(priority = 2)
	public void selectCheckBoxTest() {
		ContactPageObj.selectContact(contact1);
	}

	@Test(priority = 3)
	public void selectCheckBoxTest2() {
		ContactPageObj.selectContact(contact2);
	}

	@Test(priority = 4)
	public void selectMultipleCheckBoxTest() {
		ContactPageObj.selectContact(contact1);
		ContactPageObj.selectContact(contact2);
	}

	@Test(priority = 5)
	public void clickCreateNewContact() throws InterruptedException {
		ContactPageObj.clickNewContact();
	}

	@DataProvider
	public Object[][] getFreeCRMtestData() {
		Object data[][] = TestUtilObj.getTestData(sheetName);
		return data;
	}

	@Test(priority = 6)
	public void createSingleContactTest() throws InterruptedException {
		ContactPageObj.clickNewContact();
		Assert.assertTrue(ContactPageObj.createNewContact("TestUser1", "MiddleNameTest", "LastNameTest", "TestCompany",
				"abc@xyz.com", "Lead", "New", "Test desc", "VP"));
	}

	@Test(priority = 7, dataProvider = "getFreeCRMtestData")
	public void createMultipleNewUser(String fName, String mName, String lName, String Company, String email,
			String category, String status, String desc, String posn) throws InterruptedException {
		ContactPageObj.clickNewContact();
		ContactPageObj.createNewContact(fName, mName, lName, Company, email, category, status, desc, posn);

	}

	@Test(priority = 8, dataProvider = "getFreeCRMtestData")
	public void deleteMultipleContactTest(String fName, String mName, String lName, String Company, String email,
			String category, String status, String desc, String posn) throws InterruptedException {
		ContactPageObj.deleteContact(fName + " " + mName + " " + lName);
	}

	@Test(priority = 9)
	public void deleteSingleContact() {
		try {
			ContactPageObj.deleteContact("TestUser1 MiddleNameTest LastNameTest");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driverObj.quit();
	}
}
