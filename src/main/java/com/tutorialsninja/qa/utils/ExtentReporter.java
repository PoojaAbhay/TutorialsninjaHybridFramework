package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

		public static ExtentReports generateExtentReport() {
			
			ExtentReports extentreport = new ExtentReports();
			File extendReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReports.html");
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extendReportFile);
			
			sparkreporter.config().setTheme(Theme.DARK);
			sparkreporter.config().setReportName("Tutorials Ninja Test Automation");
			sparkreporter.config().setDocumentTitle("TN Automation Report");
			sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
			extentreport.attachReporter(sparkreporter);
			
			Properties configprop = new Properties();
			File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.propertiesfile");
			try{
				FileInputStream fisconfig = new FileInputStream(configPropFile);
				configprop.load(fisconfig);
			}catch(Throwable e) {
				e.printStackTrace();
			}
		
			extentreport.setSystemInfo("Application URL", configprop.getProperty("link"));
			extentreport.setSystemInfo("Browser Name", configprop.getProperty("browser"));
			extentreport.setSystemInfo("Email Address",configprop.getProperty("validEmail"));
			extentreport.setSystemInfo("Password",configprop.getProperty("validPassword"));
			extentreport.setSystemInfo("Opearting System", System.getProperty("os.name"));
			extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
			extentreport.setSystemInfo("User name", System.getProperty("user.name"));
			
			return extentreport;
			
		}
}
