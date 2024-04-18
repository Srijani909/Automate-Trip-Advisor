package com.selenium.hackathontest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.base.pagebase;

import tripadvisorpom.cruise;
import tripadvisorpom.cruisefinal;
import tripadvisorpom.cruisesort;
import tripadvisorpom.datepage;
import tripadvisorpom.displayhotels;
import tripadvisorpom.holidaypage;
import tripadvisorpom.sorting;
import tripadvisorpom.tripadvisorstart;
import com.selenium.resources.*;

public class hackathontest extends pagebase{
	pagebase pb;
	tripadvisorstart ta;
	holidaypage hp;
	datepage dp;
	sorting sort;
	displayhotels dh;
	cruise c;
	cruisesort csort;
	cruisefinal cf;
	ExtentReports report=ExtentReport_Manager.getreportInstance();
	ExtentTest logger=report.createTest("trip-cost");
	
	@Test(priority=0)
	public void geturl() throws InterruptedException, IOException {
		logger=report.createTest("trip-cost");
		pb=new pagebase();
		pb.invokebrowser("chrome");
		logger.log(Status.INFO,"Initializing the browser");
		ta=pb.openapplication();
		logger.log(Status.INFO,"Opening the website");
		pb.takeSS();
		logger.log(Status.INFO,"screenshot is taken");
		Thread.sleep(4000);
		logger.log(Status.PASS,"first testcase passed");
	}
	@Test(priority=1,dataProvider="getexceldata")
	public void setdestinationname(Hashtable<String,String>table) throws InterruptedException, IOException
	{
		hp=ta.search(table.get("destination name"));
		logger.log(Status.INFO,"fetching destination name from excel");
		Thread.sleep(1000);
		sort=hp.clickholidaybtn();
		logger.log(Status.INFO,"Clicking on holiday button");
		pb.takeSS();
		logger.log(Status.INFO,"screenshot is taken");
		Thread.sleep(2000);
		logger.log(Status.PASS,"second testcase passed");
	}
	@Test(priority=2)
	public void sortinghotels() throws InterruptedException, IOException 
	{
		sort.sortbytravllerrating();
		Thread.sleep(2000);
		logger.log(Status.INFO,"sorting by traveller rating");
		dp=sort.selectbylift();
		logger.log(Status.INFO,"filtering on availiability of lift");
		pb.takeSS();
		logger.log(Status.INFO,"screenshot is taken");
		Thread.sleep(2000);
		logger.log(Status.PASS,"third testcase passed");
	}
	@Test(priority=3,dataProvider="getexceldata")
	public void selectdates(Hashtable<String,String>table1) throws InterruptedException, IOException 
	{
		
		dp.selectcheckindate(table1.get("checkinmonth"),table1.get("checkindate"));
		logger.log(Status.INFO,"fetching checkin-month and checkin-date from excel");
		Thread.sleep(2000);
		dh=dp.selectcheckoutdate(table1.get("checkoutmonth"),table1.get("checkoutdate"));
		logger.log(Status.INFO,"fetching checkout-month and checkout-date from excel");
		pb.takeSS();
		logger.log(Status.INFO,"screenshot is taken");
		Thread.sleep(2000);
		logger.log(Status.PASS,"fourth testcase passed");
	}
	@Test(priority=4)
	public void displayallhotels() throws InterruptedException, IOException 
	{
		dh.displayhoteldetails();
		logger.log(Status.INFO,"diplaying hotel details");
		dh.displayfirsthotel();
		logger.log(Status.INFO,"first hotel is displayed");
		dh.displaysecondhotel();
		logger.log(Status.INFO,"second hotel is displayed");
		c=dh.displaythirdhotel();
		logger.log(Status.INFO,"third hotel is displayed");
		pb.takeSS();
		logger.log(Status.INFO,"screenshot is taken");
		logger.log(Status.PASS,"fifth testcase passed");
	}
	@Test(priority=5,dataProvider="getexceldata")
	public void dispalycruisedetails(Hashtable<String,String>table2) throws InterruptedException, IOException 
	{
		csort=c.cruisebtnclick();
		logger.log(Status.INFO,"cruise line button is clicked");
		cf=csort.sortingcruise(table2.get("cruiseline"),table2.get("cruiseship"));
		logger.log(Status.INFO,"fetching cruise data from excel");
		cf.cruisedata();
		Thread.sleep(2000);
		logger.log(Status.PASS,"sixth testcase passed");
	}
	@Test(priority=6)
	public void closebrowser() {
		pb.closebrowser();
		logger.log(Status.PASS,"seventh testcase passed");
	}
	@AfterTest
	public void endreport() {
		report.flush();
	}
		
		


	@DataProvider
	public Object getexceldata() {
		return getdatafromexcel.readdatafromexcel("Sheet1","displayhotelandcruise");
	}
}


