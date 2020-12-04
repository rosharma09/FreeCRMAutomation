package com.main.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.main.freecrm.qa.util.TestUtil;
import com.main.freecrm.qa.util.WebEventListener;

public class TestBaseFreeCRM {

	// Define the global Variables for the TestBaseFreeCRM class

	public static Properties prop;
	public static WebDriver driverObj;

	/* Create an object of EventFiringWebDriver class */

	public static EventFiringWebDriver event_firing_Driver;

	/* Create an object of the WebEventListener class */

	public static WebEventListener web_Event_Listener;

	/*
	 * The TestBaseFreeCRM class constructor is used to initialize the properties
	 * object to fetch the config {env} variables from the config.properties file
	 */

	public TestBaseFreeCRM() {

		try {

			prop = new Properties();
			FileInputStream fileInput = new FileInputStream(
					"C:\\Users\\rohan.sharma\\eclipse-workspace\\FreeCRMAutomation\\"
							+ "src\\main\\java\\com\\main\\freecrm\\qa\\config\\config.properties");

			prop.load(fileInput);

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* Create a init() method to initialize the chrome/fireFox driver */

	public static void init() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver_PATH"));

			driverObj = new ChromeDriver();

		}

		else if (browserName.toLowerCase().equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriver_PATH"));
			driverObj = new FirefoxDriver();

		}

		/* Usage of the WebEventListener */

		/* 1 . create the object of EventFiringWebDriver and pass the driver object */
		event_firing_Driver = new EventFiringWebDriver(driverObj);

		/* 2. Create the object of the WebDriverListener */
		web_Event_Listener = new WebEventListener();

		/*
		 * 3. register the object of WebEventListener with the object of
		 * EventFiringWebDruver Object
		 */
		
		event_firing_Driver.register(web_Event_Listener);
		
		
		/*4. Assign the EventFiringWebDriver object to driver Object*/
		
		driverObj = event_firing_Driver;
		
		

		driverObj.manage().window().maximize();
		driverObj.manage().deleteAllCookies();
		driverObj.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeOut, TimeUnit.SECONDS);
		driverObj.manage().timeouts().implicitlyWait(TestUtil.ImplicitllyWait, TimeUnit.SECONDS);

		driverObj.get(prop.getProperty("platform_url"));

	}

}
