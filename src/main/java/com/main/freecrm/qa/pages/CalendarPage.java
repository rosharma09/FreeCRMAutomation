package com.main.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.freecrm.qa.base.TestBaseFreeCRM;

public class CalendarPage extends TestBaseFreeCRM {

	/* Class contains the page repository for the Calendar page */

	@FindBy(xpath = "//div[text()=\"Calendar\"]")
	WebElement CalendarLabel;
	
	public CalendarPage() {
		PageFactory.initElements(driverObj,this);
	}
	
	
	public boolean isCalendarLabelVisible() {
		return CalendarLabel.isDisplayed();
	}

}
