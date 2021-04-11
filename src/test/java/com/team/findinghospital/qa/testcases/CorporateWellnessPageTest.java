package com.team.findinghospital.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.CorporateWellnessPage;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;
import com.team.findinghospital.util.ExcelData;

public class CorporateWellnessPageTest extends TestBase{
	
	CorporateWellnessPage corporateWellnessPage;
	DiagnosticPage diagnosticPage;
	SearchFilters searchFilters;
	String FormDetails[] = new String[10];
	String  name,organisation,Email, number ;

	public CorporateWellnessPageTest() {
		super();
	}
	
	    
	
	@BeforeMethod
	public void setup() {
		initialization();
		corporateWellnessPage = new CorporateWellnessPage();
		diagnosticPage = new DiagnosticPage();
		searchFilters = new SearchFilters();
		ExcelData excelData = new ExcelData();
		FormDetails  = excelData.readExcel();
		name = FormDetails[2];
		organisation =FormDetails[3];
		Email =FormDetails[4];
		number =FormDetails[5];
		
	}
	
	
	@Test
	public void scheduleDemo() throws InterruptedException {
		
		System.out.println("hyelloooo");
		diagnosticPage.CorparateWellness();
		corporateWellnessPage.scheduleDemo(name,organisation,Email,number );
		
	}
	

	
	
	 	
}
