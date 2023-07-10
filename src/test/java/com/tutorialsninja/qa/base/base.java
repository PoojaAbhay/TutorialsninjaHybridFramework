package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;

	public base() {

		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.propertiesfile");

		dataprop = new Properties();
		File datapropfile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");

		try {

			FileInputStream fis1 = new FileInputStream(datapropfile);
			dataprop.load(fis1);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browsername) {

		switch (browsername) {

		case "Chrome":

			driver = new ChromeDriver();
			break;
		case "FireFox":

			driver = new FirefoxDriver();
			break;

		case "Edge":

			driver = new EdgeDriver();
			break;

		case "Safari":

			driver = new SafariDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("link"));

		return driver;
	}
}
