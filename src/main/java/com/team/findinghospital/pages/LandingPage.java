package com.team.findinghospital.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.team.findinghospital.base.DriverSetup;
import com.team.findinghospital.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement city;
	
	@FindBy(xpath = "//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
	WebElement type;

	@FindBy(xpath= "//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[2]/label[1]")
	WebElement accredited;
//	WebDriverWait wait = new WebDriverWait(driver,60);
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void city(String cit) throws InterruptedException {
		//logger.log(Status.INFO, "Entering city name");
		List<WebElement>  l = new ArrayList<WebElement>();
		while(!city.getAttribute("value").equals(""))
		city.sendKeys(Keys.BACK_SPACE);		
		city.sendKeys(cit);
		
		Thread.sleep(2000);
	
		l=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='c-omni-suggestion-item__content']/div[@class='c-omni-suggestion-item__content__title']")));
	    //l= driver.findElements(By.xpath("//span[@class='c-omni-suggestion-item__content']/div[@class='c-omni-suggestion-item__content__title']"));  
		for(WebElement e1 : l) {
	      String s1 = e1.getText();
	      System.out.println(s1);
	      if(e1.getText().equalsIgnoreCase(cit)) {
	    	  System.out.println(s1);
	     		 e1.click();
	     		 break;
	     	 }
	      	}
	     
	}
	
	public SearchFilters type(String hospital) throws InterruptedException {
		
		 List<WebElement>  l1= new ArrayList<WebElement>();
		 type.clear();
		 Thread.sleep(2000);
		type.sendKeys(hospital);
		Thread.sleep(2000);
	     
	     // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='c-omni-suggestion-item__content__title']")));
	      l1=driver.findElements(By.xpath("//div[@class='c-omni-suggestion-item__content__title']"));
	      Thread.sleep(2000);
	      for(WebElement e : l1) {
	      String s = e.getText();
	      if(s.equalsIgnoreCase(hospital)) {
	     		 e.click();
	     		System.out.println(s);
	     		break;
	     	 }
	      	}
		//	logger.log(Status.PASS, "Search context entered");

	      return new SearchFilters();
	}
	
	
	
	

}
