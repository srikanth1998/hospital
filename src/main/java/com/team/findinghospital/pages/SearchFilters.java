package com.team.findinghospital.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.team.findinghospital.base.TestBase;

public class SearchFilters extends TestBase {
	
	
	@FindBy(xpath= "//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[2]/label[1]")
	WebElement accredited;
	
	@FindBy(xpath = "//div[contains(text(),'Diagnostics')]")
	WebElement diagnostic;
	
	@FindBy(xpath = "//div[@data-qa-id='Open_24X7_checkbox']")
	WebElement open24_7;
	
	@FindBy(xpath = "//div[@class='u-d-inlineblock u-color--white u-c-pointer']")
	WebElement filter;
	
	@FindBy(xpath = "//div[@data-qa-id='Has_Parking_checkbox']")
	WebElement parking;
	
	@FindBy(xpath = "//h2[@data-qa-id='hospital_name']")
	List<WebElement> hospital;
	
	@FindBy(xpath="//div[@class='u-margint--standard o-f-color--primary']")
	List<WebElement> topCities;
	
	
	Wait<WebDriver> wait1 = fluentWeight();
	
	public SearchFilters() {
		PageFactory.initElements(driver, this);
	}
	


	public void accreditedCheckBox() throws InterruptedException {
		
		wait1.until(ExpectedConditions.elementToBeClickable(accredited)).click();
		Thread.sleep(1000);
	}
	
	public void open24X7Checkbox() throws InterruptedException {
		wait1.until(ExpectedConditions.elementToBeClickable(open24_7)).click();
		Thread.sleep(1000);
		
	}
	
	public void filtersCheckBox() throws InterruptedException {
		
		filter.click();
		Thread.sleep(1000);
	}
	
	public void parkingCheckbox() throws InterruptedException {
		
		parking.click();
		Thread.sleep(1000);
	}
	
	
	public String[] getHospitalList() throws InterruptedException 
	{
	
		String[] hospitalList = new String[hospital.size()];
		for(int i=0;i<hospital.size();i++) {
			hospitalList[i]=hospital.get(i).getText();
		}
		Thread.sleep(1000);

		return hospitalList;
		
		
	}
	
	public DiagnosticPage diagnostic() throws InterruptedException {
		Thread.sleep(1000);
		diagnostic.click();

		return new DiagnosticPage();
		
		
	}
	

	
}
