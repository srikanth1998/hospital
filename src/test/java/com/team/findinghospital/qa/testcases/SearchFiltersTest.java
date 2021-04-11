package com.team.findinghospital.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;
import com.team.findinghospital.util.ExcelData;
import com.team.findinghospital.util.WriteToExcel;

public class SearchFiltersTest extends TestBase {
	
	LandingPage landingPage;
	SearchFilters searchFilters;
	String LandinPageData[] = new String[2];
	
	public SearchFiltersTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		ExcelData excelData = new ExcelData();
		LandinPageData  = ExcelData.readExcel();
		
	}
	@Test
	public void cityTest() throws InterruptedException, IOException {
		landingPage.city(LandinPageData[0]);
		searchFilters=landingPage.type(LandinPageData[1]);
		searchFilters.accreditedCheckBox();
		searchFilters.open24X7Checkbox();
		searchFilters.filtersCheckBox();
		searchFilters.parkingCheckbox();
		
		String[] hospitalList = searchFilters.getHospitalList();
		
		for(String temp:hospitalList)
			System.out.println(temp);
		
		WriteToExcel.Write(hospitalList);
		searchFilters.diagnostic();
		
	}
	
}
