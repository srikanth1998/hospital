package com.team.findinghospital.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelData {
	static WebDriver driver;
	public static String path = System.getProperty("user.dir") + "\\TestData\\TestInput.xlsx";
	public static String[] readExcel() {
		String[] LandingPageData = new String[10];
		try {
			/*
			 * Getting the Relative path for excel from Source Excel folder
			 */
			String filePath = System.getProperty("user.dir") + "\\TestData\\TestInput.xlsx";
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(0);
			LandingPageData[0] = String.valueOf(ws.getRow(0).getCell(0));
			LandingPageData[1] = String.valueOf(ws.getRow(0).getCell(1));
			LandingPageData[2] = String.valueOf(ws.getRow(1).getCell(3));
			LandingPageData[3] = String.valueOf(ws.getRow(1).getCell(4));
			LandingPageData[4] = String.valueOf(ws.getRow(1).getCell(5));
			LandingPageData[5] = String.valueOf(ws.getRow(1).getCell(6));
			
			System.out.println(LandingPageData[5]);
			
			return LandingPageData ;
		} catch (Exception e) {
			e.printStackTrace();
			return LandingPageData;
		}

	}
	public static void main(String[] args) throws IOException {
		ExcelData.readExcel();
		
	
	}

}
