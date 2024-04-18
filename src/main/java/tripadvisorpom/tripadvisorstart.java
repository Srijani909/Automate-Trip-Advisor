package tripadvisorpom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.base.pagebase;

public class tripadvisorstart extends pagebase {
	@FindBy(xpath = "//input[@class='fhEMT _G B- z _J Cj R0' and @placeholder='Where to?']")
	public WebElement searchbox;
	@FindBy(xpath = "//a[@href='/Tourism-g294207-Nairobi-Vacations.html' and @role='option']")
	public WebElement searchresult;

	public holidaypage search(String name) throws InterruptedException {
		searchbox.click();
		//WebDriverWait wait=new WebDriverWait(driver,30);
		searchbox.sendKeys(name);
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"typeahead_results\\\"]/a[1]")));
		searchresult.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, holidaypage.class);
	}

}
