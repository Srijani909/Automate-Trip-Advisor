package tripadvisorpom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.base.pagebase;

public class displayhotels extends pagebase {
	@FindBy(xpath = "//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/div[1]")
	public List<WebElement> hotelrates;
	@FindBy(xpath = "//*[@id=\"component_2\"]/div/div/div/div[1]/div/div/div/div/div/h2/a")
	public List<WebElement> hotelnames;

	public void displayhoteldetails() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			String hotelname = hotelnames.get(i).getText();
			System.out.println("the name of the hotel is:" + " " + hotelname);
			String hotelrate = hotelrates.get(i).getText();
			System.out.println("charges per night is:" + " " + hotelrate);

		}
	}

	public void displayfirsthotel() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)", "");
		Thread.sleep(2000);
		hotelnames.get(0).click();
		Thread.sleep(2000);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String mainpage = itr.next();
		String nextpage1 = itr.next();
		driver.switchTo().window(nextpage1);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		String price1 = driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]")).getText();
		System.out.println("total charge for 1.hotel:" + price1);
		driver.close();
		driver.switchTo().window(mainpage);
	}

	public void displaysecondhotel() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			hotelnames.get(1).click();
			Thread.sleep(2000);
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> itr = ids.iterator();
			String mainpage = itr.next();
			String nextpage2 = itr.next();
			driver.switchTo().window(nextpage2);
			js.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(2000);
		    String price2 = driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[4]/div[2]")).getText();
		System.out.println("total charge for 2.hotel:" + price2);
		driver.close();
		driver.switchTo().window(mainpage);
		}
	public cruise displaythirdhotel() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
		Thread.sleep(2000);
		hotelnames.get(2).click();
		Thread.sleep(2000);
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String mainpage = itr.next();
		String nextpage3= itr.next();
		driver.switchTo().window(nextpage3);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
	    String price3 = driver
			.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[4]/div[2]")).getText();
	System.out.println("total charge for 3.hotel:" + price3);
	driver.close();
	driver.switchTo().window(mainpage);
	return PageFactory.initElements(driver,cruise.class);
}
}

