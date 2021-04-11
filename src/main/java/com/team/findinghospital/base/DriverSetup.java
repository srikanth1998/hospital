package com.team.findinghospital.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.team.findinghospital.util.ExtetntReport;

public class DriverSetup {
	public static WebDriver driver;
	public static Actions act;
	static String driverPath;
	public ExtentReports report = ExtetntReport.getReportInstance();
	public static ExtentTest logger;
	//public static WebDriverWait wait;
	
	
	public DriverSetup(WebDriver driver, ExtentTest logger) {
		this.logger=logger;
		this.driver=driver;
	}
	


	/*
	 * ChromeDriver Setup Method
	 */
	public static WebDriver setChromeDriver() {
		try {
			driverPath = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
	}

	/*
	 * Internet Explorer Driver Setup Method
	 */
	public static WebDriver setIEDriver() {
		

		try {
			driverPath = System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
	}

	/*
	 * Microsoft Edge Driver Setup Method
	 */
	public static WebDriver setEdgeDriver() {
		try {
			driverPath = System.getProperty("user.dir") + "\\Driver\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
	}

	/*
	 * Fire Fox Driver Setup Method
	 */
	public static WebDriver setFireFoxDriver() {
		try {
			driverPath = System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
	}

}
