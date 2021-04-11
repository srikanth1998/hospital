package com.team.findinghospital.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;

public class DiagnosticPageTest extends TestBase {
	
	DiagnosticPage diagnosticsPage;
	LandingPage landingPage;
	SearchFilters searchFilters;
	public DiagnosticPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		diagnosticsPage = new DiagnosticPage();	
		searchFilters = new SearchFilters();
	}
	
	@Test
	public void cityTest() throws InterruptedException {
		
		
		searchFilters.diagnostic();
		
		String[] topCities = diagnosticsPage.getTopCities();
		for(String temp:topCities)
			System.out.println(temp);
		
		
		diagnosticsPage.CorparateWellness();
		//diagnosticsPage.scheduleDemo();
		
		
	}
	
}
