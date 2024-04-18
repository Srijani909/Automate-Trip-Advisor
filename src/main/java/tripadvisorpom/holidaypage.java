package tripadvisorpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.pagebase;

public class holidaypage extends pagebase {
	@FindBy(xpath="//*[@id=\"lithium-root\"]/main/div[1]/div[2]/div/div/div[2]/a")
	public WebElement holidaybtn;
	
	public sorting clickholidaybtn() throws InterruptedException {
		Thread.sleep(2000);
		holidaybtn.click();
		Thread.sleep(2000);
		return PageFactory.initElements(driver,sorting.class);
	}

}
