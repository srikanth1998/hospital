package com.team.findinghospital.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.team.findinghospital.util.TestUtil;



public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	

	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\welcome\\eclipse-workspace\\findinghospital\\src\\main\\java\\com\\team\\findinghospital\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		//String browserName = prop.getProperty("browser");
		int  browserChoice =3;
		if (browserChoice == 1) {
			driver = DriverSetup.setChromeDriver();
		} else if (browserChoice == 2) {
			driver = DriverSetup.setIEDriver();
		} else if (browserChoice == 3) {
			driver = DriverSetup.setEdgeDriver();
		} else if (browserChoice == 4) {
			driver = DriverSetup.setFireFoxDriver();
		} else {
			System.out.println("Invalid data...");
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,60);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//flutWeight();
		driver.get(prop.getProperty("url"));

}
	
	public Wait<WebDriver> fluentWeight() {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		return wait1;
		}
}
