package com.team.findinghospital.util;

import org.testng.IReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.relevantcodes.extentreports.LogStatus;


public abstract class ExtetntReport implements IReporter {
		
	
	static ExtentReports report;
	static ExtentHtmlReporter htmlReporter;
	static  ExtentTest test;
	
	public static  ExtentReports getReportInstance(){
		report = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//report.html");
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Environment", "UAT");
		report.setSystemInfo("Build Number", "10.8.1");
		report.setSystemInfo("Browser", "Chrome");
		htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
		htmlReporter.config().setReportName("All Headlines UI Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		return report;
			
		
	}
		
	}
	
	

