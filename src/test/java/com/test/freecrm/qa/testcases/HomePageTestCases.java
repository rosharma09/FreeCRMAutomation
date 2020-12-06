package com.test.freecrm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.freecrm.qa.base.TestBaseFreeCRM;
import com.main.freecrm.qa.pages.CalendarPage;
import com.main.freecrm.qa.pages.CallsPage;
import com.main.freecrm.qa.pages.CampaignsPage;
import com.main.freecrm.qa.pages.CasesPage;
import com.main.freecrm.qa.pages.CompaniesPage;
import com.main.freecrm.qa.pages.ContactsPage;
import com.main.freecrm.qa.pages.DealsPage;
import com.main.freecrm.qa.pages.DocumentPage;
import com.main.freecrm.qa.pages.EmailPage;
import com.main.freecrm.qa.pages.FormsPage;
import com.main.freecrm.qa.pages.HomePage;
import com.main.freecrm.qa.pages.LoginPage;
import com.main.freecrm.qa.pages.TaskPage;
import com.main.freecrm.qa.util.TestUtil;

public class HomePageTestCases extends TestBaseFreeCRM {

	LoginPage LoginPageObj;
	HomePage HomePageObj;
	CalendarPage CalendarPageObj;
	ContactsPage contactPageObj;
	CompaniesPage CompaniesPageObj;
	DealsPage DealsPageObj;
	TaskPage TaskPageObj;
	CasesPage CasePageObj;
	CallsPage CallsPageObj;
	DocumentPage DocumentsPageObj;
	EmailPage EmailPageObj;
	CampaignsPage CampaingsClickObj;
	FormsPage FormsPageObj;
	
	public static TestUtil TestUtilObj = new TestUtil();
	public static String SheetName = "SearchPageData";

	public HomePageTestCases() {
		super();
	}

	@BeforeMethod
	public void setup() {
		init();
		LoginPageObj = new LoginPage();
		CalendarPageObj = new CalendarPage();
		HomePageObj = LoginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void validateTitleTest() {
		String HomePageTitle = HomePageObj.fetchTitle();
		Assert.assertEquals(HomePageTitle, "Cogmento CRM", "The home Page title is not matched");
	}

	@Test(priority = 2)
	public void validateUserProfileTest() {
		Assert.assertTrue(HomePageObj.isUserLabelDisplayed());
	}

	@Test(priority = 3)
	public void calendarClickTest() {
		CalendarPageObj = HomePageObj.clickCalendarlink();
		Assert.assertTrue(CalendarPageObj.isCalendarLabelVisible());
	}

	@Test(priority = 3)
	public void contactClickTest() {
		contactPageObj = HomePageObj.clickContactslink();
	}

	@Test(priority = 4)
	public void companiesClickTest() {
		CompaniesPageObj = HomePageObj.clickCompanieslink();
	}

	@Test(priority = 5)
	public void dealClickTest() {
		DealsPageObj = HomePageObj.clickDealslink();
	}

	@Test(priority = 5)
	public void TaskClickTest() {
		TaskPageObj = HomePageObj.clickTasklink();
	}

	@Test(priority = 6)
	public void caseClickTest() {
		CasePageObj = HomePageObj.clickCaseslink();
	}

	@Test(priority = 7)
	public void callsClickTest() {
		CallsPageObj = HomePageObj.clickCallslink();
	}

	@Test(priority = 8)
	public void documentsClickTest() {
		DocumentsPageObj = HomePageObj.clickDocumentslink();
	}

	@Test(priority = 9)
	public void EmailClickTest() {
		EmailPageObj = HomePageObj.clickEmaillink();
	}

	@Test(priority = 10)
	public void CampaingsClickTest() {
		CampaingsClickObj = HomePageObj.clickCampainsLink();
	}

	@Test(priority = 11)
	public void FormsClickTest() {
		FormsPageObj = HomePageObj.clickFormsLink();
	}
	
	
	@DataProvider
	public Object[][] getFreeCRMTestData() {
		Object[][] data = TestUtilObj.getTestData(SheetName);
		return data;
	}

//	@Test(priority = 12 , dataProvider = "getFreeCRMTestData")
//	public void searchBoxTest(String searchText) {
//		HomePageObj.searchText(searchText);
//
//		WebElement searchResultLabel = driverObj
//				.findElement(By.xpath("//div[@Class=\"ui header item mb5 light-black\"]"));
//		String SearchResultText = searchResultLabel.getText();
//		Assert.assertEquals(SearchResultText, "Search Results: "+searchText);
//	}

	@AfterMethod
	public void tearDown() {
		driverObj.quit();
	}

}