package tripadvisorpom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.base.pagebase;

public class cruisefinal extends pagebase {
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[3]/span/button")
	public WebElement searchbtn;

	public void cruisedata() throws InterruptedException {
		Thread.sleep(1000);
		searchbtn.click();
		Thread.sleep(2000);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String mainpage = itr.next();
		String nextpage = itr.next();
        driver.switchTo().window(nextpage);
        Thread.sleep(2000);
        WebElement cruisename=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/div/div/h1"));
        String cn=cruisename.getText();
        System.out.println("Cruise name:"+cn);
        WebElement launchyear=driver.findElement(By.xpath("//div[contains(text(),\"Launched: 2010\")]"));
        WebElement passcrew=driver.findElement(By.xpath("//div[contains(text(),\"Passengers: 2,050\")]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",launchyear);
		Thread.sleep(2000);
		String pc=passcrew.getText();
		System.out.println(pc);
		String ly=launchyear.getText();
		System.out.println(ly);
		Thread.sleep(2000);
		WebElement language=driver.findElement(By.xpath("//*[@id=\"ship_reviews\"]/div/div[2]/div/div[1]/div[1]/div[3]/ul/li[3]/label"));
		js.executeScript("arguments[0].scrollIntoView(true)",language);
		List<WebElement> lang= driver
				.findElements(By.xpath("//*[@id='ship_reviews']/div/div[2]/div/div[1]/div[1]/div[3]/ul/li"));
		for (int k = 0; k < lang.size(); k++) {
			String l = lang.get(k).getText();
			System.out.println(l);
		}
		driver.close();

	}

}
