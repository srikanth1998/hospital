 package com.team.findinghospital.qa.testcases;

import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;
import com.team.findinghospital.util.CaptureScreen;
import com.team.findinghospital.util.ExcelData;
import com.team.findinghospital.util.ExtetntReport;

public class LandingPageTest extends TestBase {
	LandingPage landingPage;
	CaptureScreen captureScreen;

	String LandinPageData[] = new String[2];
	
	public LandingPageTest() {
		super();
	}
	

	@Test
	public void cityTest() throws InterruptedException {
		
		landingPage.city(LandinPageData[0]);
		landingPage.type(LandinPageData[1]);
		
		
	}

	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		ExcelData excelData = new ExcelData();
		LandinPageData  = excelData.readExcel();
		captureScreen =  new CaptureScreen();
		
	}
	@AfterMethod
	public void close() {
		CaptureScreen.screenShot();
		driver.close();
		}	
	
	
	
	
}
