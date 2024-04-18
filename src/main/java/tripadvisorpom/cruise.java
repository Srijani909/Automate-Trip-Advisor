package tripadvisorpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.pagebase;

public class cruise extends pagebase{
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[4]/div/nav/div/div/div[1]/a[9]")
	public WebElement cruisebtn;
	
	public cruisesort cruisebtnclick() throws InterruptedException {
		cruisebtn.click();
		Thread.sleep(2000);
		return PageFactory.initElements(driver,cruisesort.class);
	}

}
