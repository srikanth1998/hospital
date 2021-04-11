package com.team.findinghospital.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.team.findinghospital.base.TestBase;

public class DiagnosticPage extends TestBase {
	 
	@FindBy(xpath="//div[@class ='u-margint--standard o-f-color--primary']")
	List<WebElement> topCities;
	 @FindBy(id="name")
	 public WebElement name;
	 
	 @FindBy(id="organization_name")
	 public WebElement organizationName;
	 
	 @FindBy(id="official_email_id")
	 public WebElement emailId;
	 
	 @FindBy(id="official_phone_no")
	 public WebElement phoneNo;
	 
	 @FindBy(id="button-style")
	 public WebElement schedule;
	
	List<WebElement>  l2 = new ArrayList<WebElement>();	
	
	public void DiagnosticsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String[] getTopCities() {
		
		topCities = driver.findElements(By.xpath("//div[@class ='u-margint--standard o-f-color--primary']"));
		String[] cities = new String[topCities.size()];
		for(int i=0;i<topCities.size();i++) {
			cities[i]=topCities.get(i).getText();
			
		}		
		driver.navigate().back();
		return cities;
	}
	
	String child =null;
	String parent=driver.getWindowHandle();
	public CorporateWellnessPage CorparateWellness() throws InterruptedException {

		driver.findElement(By.cssSelector("div.global-nav-bar:nth-child(1) div.practo_GlobalNavigation div.navbar.desktop.en:nth-child(2) div.wrapper.branding div.nav-right.text-right > div.providers-marketing.nav-items.nav-items--additional-link.hover-dark.u-d-trigger.dropdown-toggle:nth-child(1)")).click();
		driver.findElement(By.cssSelector("div.global-nav-bar:nth-child(1) div.practo_GlobalNavigation div.navbar.desktop.en:nth-child(2) div.wrapper.branding div.nav-right.text-right div.providers-marketing.nav-items.nav-items--additional-link.hover-dark.u-d-trigger.dropdown-toggle:nth-child(1) div.u-d.nav-dropdown.text-left.active-state div.u-d-item:nth-child(4) > a.nav-interact")).click();
		Set<String>s=driver.getWindowHandles();		
		for(String c:s) {
			if(!parent.equalsIgnoreCase(c)) {
				driver.switchTo().window(c);			
			}
		}
		return new CorporateWellnessPage();		
	}
	

}
