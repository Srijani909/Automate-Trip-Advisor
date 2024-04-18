package tripadvisorpom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.pagebase;

public class cruisesort extends pagebase {
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/div/button")
	public WebElement cruiselinebtn;
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[2]/div/button")
	public WebElement cruiseshipbtn;

	public cruisefinal sortingcruise(String name1, String name2) throws InterruptedException {
		cruiselinebtn.click();
		Thread.sleep(2000);
		List<WebElement> lineelements = driver
				.findElements(By.xpath("//*[@id=\"component_1\"]/div/div[2]/div/div[1]/div/div/ul/li"));
		for (int i = 0; i < lineelements.size(); i++) {
			String select = lineelements.get(i).getText();
			if (select.equals(name1)) {
				lineelements.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		cruiseshipbtn.click();
		Thread.sleep(2000);
		List<WebElement> shipelements = driver
				.findElements(By.xpath("//*[@id=\"component_1\"]/div/div[2]/div/div[2]/div/div/ul/li"));
		for (int j = 0; j < shipelements.size(); j++) {
			String select = shipelements.get(j).getText();
			if (select.equals(name2)) {
				shipelements.get(j).click();
				break;
			}
		}
		return PageFactory.initElements(driver, cruisefinal.class);
	}

}
