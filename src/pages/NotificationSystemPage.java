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
		return driver.findElement(By.className("system_message alert alert--success"));
	}
	
	public void thereIsNoLongerMessage() {
		ExpectedConditions.invisibilityOf(driver.findElement(By.className("system_message alert alert--success")));
	}

	
	
	
	
	
	
	
}
