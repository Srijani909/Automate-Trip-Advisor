package com.selenium.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReport_Manager {

	public static ExtentReports report;

	public static ExtentReports getreportInstance() {
		String reportname = dateutil.gettimedata();

		if (report == null) {
			ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\htmlreports\\" + reportname + ".html");
			report = new ExtentReports();
			report.attachReporter(htmlreporter);

			report.setSystemInfo("OS", "Windows 11");
			report.setSystemInfo("software", "Selenium");
			report.setSystemInfo("Browser", "Chrome");

			htmlreporter.config().setDocumentTitle("hackthon full report");
			htmlreporter.config().setReportName("calculate tripcost(Tripadvisor)");
			htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlreporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

		}
		return report;
	}
}