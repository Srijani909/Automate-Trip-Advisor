package tripadvisorpom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.base.pagebase;

public class datepage extends pagebase {
	@FindBy(xpath = "//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[2]/div[4]/div/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/div")
	public WebElement checkinbtn;

	@FindBy(xpath = "//*[@id=\"component_2\"]/div/div[3]/div/div[1]/div[2]/div[3]/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div/div")
	public WebElement checkoutbtn;

	public void selectcheckindate(String checkinmonth,String checkindate) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-400)","");
		Thread.sleep(2000);
		checkinbtn.click();
		Thread.sleep(2000);

		while (true) {

			String text1 = driver
					.findElement(By.xpath(
							"//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div/div[1]"))
					.getText();
			if (text1.equals(checkinmonth)) {
				break;
			} else {
				driver.findElement(
						By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[1]/div[2]"))
						.click();
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[contains(text(), "
						+ checkindate + ")]")));
		driver.findElement(By.xpath(
				"//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div/div[3]/div/div[contains(text(),"
						+ checkindate + ")]"))
				.click();

	}

	public displayhotels selectcheckoutdate(String checkoutmonth,String checkoutdate) throws InterruptedException {
		Thread.sleep(2000);
		while (true) {
			String text2 = driver
					.findElement(By.xpath(
							"//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div/div[1]"))
					.getText();
			if (text2.equals(checkoutmonth)) {
				break;
			} else {
				driver.findElement(
						By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[1]/div[2]"))
						.click();
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div/div[contains(text(),"
						+ checkoutdate + ")]")));
		driver.findElement(By.xpath(
				"//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div/div[contains(text(),"
						+ checkoutdate + ")]"))
				.click();

		return PageFactory.initElements(driver, displayhotels.class);

	}
}