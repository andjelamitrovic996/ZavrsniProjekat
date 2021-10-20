package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getConfirmationMsg() {
		return driver.findElement(By.xpath("/html/body/div[2]"));
	}
	
	public void thereIsNoLongerMessage() {
		ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("/html/body/div[2]")));
	}

	
	
	
	
	
	
	
}
