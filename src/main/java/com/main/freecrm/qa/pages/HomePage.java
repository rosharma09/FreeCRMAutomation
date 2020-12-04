package com.main.freecrm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.freecrm.qa.base.TestBaseFreeCRM;

public class HomePage extends TestBaseFreeCRM {

	/* This is the page repository for the Home Page */

	/* Page Factory */

	/*
	 * There is a concept of cache lookup in selenium, where in the element is
	 * directly loaded from the catch instead of searching in the browser When to
	 * use cache lookup?? Use the cahce lookup only in case the element doesn't
	 * change
	 * 
	 * In case if the browser is refreshed, the cachelookup will throw staleelement
	 * exception
	 * 
	 * Usage; @CacheLookUp
	 */

	@FindBy(xpath = "//span[contains(text(),\"rohan sharma\")]")
	@CacheLookup
	WebElement UserLabelDisplay;

	@FindBy(xpath = "//span[contains(text(),\"Calendar\")]")
	WebElement calenderLink;

	@FindBy(xpath = "//span[contains(text(),\"Contacts\")]")
	WebElement contactLink;

	@FindBy(xpath = "//span[contains(text(),\"Companies\")]")
	WebElement companiesLink;

	@FindBy(xpath = "//span[contains(text(),\"Deals\")]")
	WebElement DealsLink;

	@FindBy(xpath = "//span[contains(text(),\"Tasks\")]")
	WebElement TaskLink;

	@FindBy(xpath = "//span[contains(text(),\"Cases\")]")
	WebElement CasesLink;

	@FindBy(xpath = "//span[contains(text(),\"Calls\")]")
	WebElement callsLink;

	@FindBy(xpath = "//span[contains(text(),\"Documents\")]")
	WebElement documentsLink;

	@FindBy(xpath = "//span[contains(text(),\"Email\")]")
	WebElement emailLink;

	@FindBy(xpath = "//span[contains(text(),\"Campaigns\")]")
	WebElement campaingsLink;

	@FindBy(xpath = "//span[contains(text(),\"Forms\")]")
	WebElement formsLink;

	@FindBy(xpath = "//input[@placeholder = \"Search\" and @type=\"text\"]")
	WebElement searchBox;

	public HomePage() {
		PageFactory.initElements(driverObj, this);

	}

	public String fetchTitle() {
		return driverObj.getTitle();
	}

	public boolean isUserLabelDisplayed() {
		return UserLabelDisplay.isDisplayed();
	}

	public CalendarPage clickCalendarlink() {
		calenderLink.click();
		return new CalendarPage();
	}

	public ContactsPage clickContactslink() {
		contactLink.click();
		return new ContactsPage();
	}

	public CompaniesPage clickCompanieslink() {
		contactLink.click();
		return new CompaniesPage();
	}

	public DealsPage clickDealslink() {
		contactLink.click();
		return new DealsPage();

	}

	public TaskPage clickTasklink() {
		contactLink.click();
		return new TaskPage();

	}

	public CasesPage clickCaseslink() {
		contactLink.click();
		return new CasesPage();

	}

	public CallsPage clickCallslink() {
		contactLink.click();
		return new CallsPage();

	}

	public DocumentPage clickDocumentslink() {
		contactLink.click();
		return new DocumentPage();

	}

	public EmailPage clickEmaillink() {
		emailLink.click();
		return new EmailPage();

	}

	public CampaignsPage clickCampainsLink() {
		contactLink.click();
		return new CampaignsPage();

	}

	public FormsPage clickFormsLink() {
		formsLink.click();
		return new FormsPage();

	}

	public void searchText(String toSearch) {
		searchBox.sendKeys(toSearch);
		searchBox.sendKeys(Keys.ENTER);

	}

}
