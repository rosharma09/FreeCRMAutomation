package com.main.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.freecrm.qa.base.TestBaseFreeCRM;
import com.main.freecrm.qa.util.TestUtil;

public class ContactsPage extends TestBaseFreeCRM {

	/* This is the page repository for the contacts page */

	@FindBy(xpath = "//div[@class = \"ui header item mb5 light-black\"]")
	WebElement contactLabel;

	@FindBy(xpath = "//div[@class=\"ui header item mb5 light-black\" and text() = \"Create New Contact\"]")
	WebElement newContactLabel;

	/* For the create new Contact */

	@FindBy(xpath = "//button[@class = \"ui linkedin button\" and text() = \"New\"]")
	WebElement createNewContactBtn;

	@FindBy(xpath = "//input[@name=\"first_name\" and @type = \"text\"]")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@name=\"last_name\" and @type = \"text\"]")
	WebElement lastNameField;

	@FindBy(xpath = "//input[@name=\"middle_name\" and @type = \"text\"]")
	WebElement middleNameField;

	@FindBy(xpath = "//div[@name=\"company\"]//input[@Class=\"search\" and @type = \"text\" and @tabindex = \"0\"]")
	WebElement companyField;

	@FindBy(xpath = "//input[@placeholder = \"Email address\" and @type = \"text\"]")
	WebElement emailField;

	@FindBy(xpath = "//div[@name=\"category\" and @Class=\"ui selection dropdown\"]")
	WebElement categorySelection;

	@FindBy(xpath = "//div[@name = \"status\" and @Class = \"ui selection dropdown\"]")
	WebElement statusSelection;

	@FindBy(xpath = "//textarea[@name = \"description\"]")
	WebElement descriptionTextField;

	@FindBy(xpath = "//input[@name = \"position\"]")
	WebElement postionField;

	@FindBy(xpath = "//button[@class= \"ui linkedin button\"]")
	WebElement saveBtn;

	/* Initialize the page factory for the contacts page elements */

	public ContactsPage() {
		PageFactory.initElements(driverObj, this);
	}

	/* Create the methods for the contact page */

	public boolean isContactsLabelDisplayed() {
		return contactLabel.isDisplayed();
	}

	public void selectContact(String contactName) {
		WebElement toSelect = driverObj.findElement(By.xpath("//td[text() = \"" + contactName
				+ "\"]//preceding-sibling::td//div[@class=\"ui fitted read-only checkbox\"]"));
		toSelect.click();
	}

	public void clickNewContact() throws InterruptedException {
		Thread.sleep(4000);
		TestUtil.explicitWait(contactLabel, 40);
		createNewContactBtn.click();
	}

	public boolean isNewContactLabelDisplayed() {
		return newContactLabel.isDisplayed();
	}

	public void selectCategory(String Category) {

		// xpath = //div//span[text() = "Customer"]

		categorySelection.click();
		WebElement categoryToSelect = driverObj.findElement(By.xpath("//div//span[text() = \"" + Category + "\"]"));
		categoryToSelect.click();
	}

	public void selectStatus(String status) {

		// xpath = //div//span[text() = "New"]

		statusSelection.click();
		WebElement statusToSelect = driverObj.findElement(By.xpath("//div//span[text() = \"" + status + "\"]"));
		statusToSelect.click();

	}

	public boolean createNewContact(String fName, String mName, String lName, String Company, String email,
			String category, String status, String desc, String posn) {

		firstNameField.sendKeys(fName);
		middleNameField.sendKeys(mName);
		lastNameField.sendKeys(lName);
		companyField.sendKeys(Company);
		emailField.sendKeys(email);
		selectCategory(category);
		selectStatus(status);
		descriptionTextField.sendKeys(desc);
		postionField.sendKeys(posn);
		saveBtn.click();

		String xpath = "//div[text() = \"" + fName + " " + lName + "\"]";
		return driverObj.findElement(By.xpath(xpath)).isDisplayed();
	}

	public void deleteContact(String Name) throws InterruptedException {

		String xpath = "//td[text() = \""+Name+"\"]//parent::tr//td[@class=\"right aligned collapsing options-buttons-container\"]//button[@class=\"ui icon inverted button\"]";
		WebElement deleteBtnForELement = driverObj.findElement(By.xpath(xpath));
		Thread.sleep(4000);
		deleteBtnForELement.click();
		//String content = driverObj.findElement(By.xpath("//div[@Class=\"content\"]//p")).getText();
		
		WebElement deleteBtn = driverObj.findElement(By.xpath("//button[text() = \"Delete\"]"));
		Thread.sleep(4000);
		deleteBtn.click();
		Thread.sleep(4000);
		
	}

}
