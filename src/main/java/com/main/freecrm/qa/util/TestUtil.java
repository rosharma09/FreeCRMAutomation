package com.main.freecrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.freecrm.qa.base.TestBaseFreeCRM;

public class TestUtil extends TestBaseFreeCRM {

	/*
	 * This is the utility class having some of the common Utilities and functions
	 */

	/* Define the PageLoad and Implicit wait for the project */
	public static long pageLoadTimeOut = 40;
	public static long ImplicitllyWait = 30;

	public static String TestDataFile = "C:\\Users\\rohan.sharma\\eclipse-workspace"
			+ "\\FreeCRMAutomation\\src\\main\\java\\com\\main\\freecrm\\qa\\testdata\\FreeCRMTestData.xlsx";

	/* Define the variables for the data load from testDataFile */
	
	static Workbook book;
	static Sheet sheet;

//	static Workbook book;
//
//	static org.apache.poi.ss.usermodel.Sheet sheet;

	/*
	 * Function to read the data from the excel file We are going to define a
	 * function which takes a sheetName as the input and returns a 2D object array
	 */

	public Object[][] getTestData(String SheetName) {

		FileInputStream fileInput = null;
	
		try {
			fileInput = new FileInputStream(TestDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}

		return data;

	}

	/* Function to define explicit wait for the element */

	public static void explicitWait(WebElement element, int WaitForTime) {

		WebDriverWait waitForElement = new WebDriverWait(driverObj, WaitForTime);
		waitForElement.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	
	/*Define a method to take the screenshot when an exception occurs during the test run*/
	
	public static void takeScreenShotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driverObj).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(srcFile, new File(currentDir + "/ScreenShots/" + System.currentTimeMillis() + ".png"));
	}
}
