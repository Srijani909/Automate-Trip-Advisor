package tripadvisorpom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.base.pagebase;

public class sorting extends pagebase {
	@FindBy(xpath="//*[@id=\"component_2\"]/div/div[2]/div/div[1]/div/div[3]/div/div/div/div[2]")
	public WebElement guestbtn;
	@FindBy(xpath="//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div[2]/div/div[2]/span[2]/span")
	public WebElement guestinc;
	@FindBy(xpath="//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/button")
	public WebElement applybtn;
	@FindBy(xpath = "//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/div/div[2]")
	public WebElement sortbtn;
	@FindBy(xpath = "//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div[4]/div")
	public WebElement travellerratingbtn;
	//@FindBy(xpath = "//*[@id=\"component_2\"]/div/div[2]/div/div[2]/div[1]/button")
	//public WebElement filter;
	@FindBy(xpath = "//div[text()='Amenities']//following-sibling::div[@class='eduCX Cj b S4 H3 _S']")
	public WebElement showmore;
	@FindBy(xpath = "//div[contains(text(),'Elevator/Lift access')]")
	public WebElement liftbtn;
	//*[@id="component_2"]/div/div[3]/div/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div[2]/button
	public void sortbytravllerrating() throws InterruptedException {
		sortbtn.click();
		Thread.sleep(2000);
		travellerratingbtn.click();
		Thread.sleep(2000);
		guestbtn.click();
		Thread.sleep(1000);
		guestinc.click();
		Thread.sleep(1000);
		guestinc.click();
		Thread.sleep(2000);
		applybtn.click();
		Thread.sleep(4000);
		}
	public datepage selectbylift() throws InterruptedException{
		//filter.click();
		//Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		showmore.click();
		Thread.sleep(2000);
		liftbtn.click();
		Thread.sleep(2000);
		
		return PageFactory.initElements(driver,datepage.class);
	}

}
