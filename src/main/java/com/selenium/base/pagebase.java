package com.selenium.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.selenium.resources.dateutil;

import tripadvisorpom.tripadvisorstart;


public class pagebase {
	public static WebDriver driver;

	public void invokebrowser(String browsername) throws FileNotFoundException {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} else if (browsername.equalsIgnoreCase("Mozila")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
	}

	public tripadvisorstart openapplication() throws InterruptedException {
		driver.get("https://www.tripadvisor.in/");
		Thread.sleep(4000);
		return PageFactory.initElements(driver, tripadvisorstart.class);
	}

	public void closebrowser() {
		driver.quit();
	}

	public void takeSS() throws IOException {
		TakesScreenshot takess = (TakesScreenshot) driver;
		File srcfile = takess.getScreenshotAs(OutputType.FILE);
		String ss = dateutil.gettimedata() + ".png";
		File destfile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + ss);
		FileUtils.copyFile(srcfile, destfile);
	}

}
