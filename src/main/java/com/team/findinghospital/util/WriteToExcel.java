package com.team.findinghospital.util;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.team.findinghospital.pages.LandingPage;

public class WriteToExcel {
	public static void Write(String[] hospitalList) throws IOException {
	
		
		String filePath = System.getProperty("user.dir") + "\\TestData\\TestInput.xlsx";
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		FileOutputStream write = new FileOutputStream("TestInput.xlsx");
		System.out.println(sheet.getLastRowNum());
		int rownum =sheet.getLastRowNum();
		
	
		for(String temp:hospitalList) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(1);
			cell.setCellValue(temp);
			
		}
		
		wb.write(write);
		write.close();
		
		
		
		
	}

}