package com.team.findinghospital.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.team.findinghospital.base.TestBase;

public class CorporateWellnessPage extends TestBase{


	public void CorporateWellnessPage() throws InterruptedException {
		PageFactory.initElements(driver, this);
		
	}
	

	 public void scheduleDemo(String name,String c, String Email, String number ) throws InterruptedException {

			   String winHandleBefore= driver.getWindowHandle();
			  
			   driver.findElement(By.id("name")).sendKeys(name);
			   driver.findElement(By.id("organization_name")).sendKeys(name);
			   driver.findElement(By.id("official_email_id")).sendKeys(Email);
			   driver.findElement(By.id("official_phone_no")).sendKeys(number);
			   driver.findElement(By.id("button-style")).click();
			  
			 
			   driver.switchTo().window(winHandleBefore);
			
			  } 
		 
}
