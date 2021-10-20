package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasicPage {
	
	protected WebDriver driver;
	Actions actionProvider;

	public BasicPage(WebDriver driver) {
		this.driver = driver;
		this.actionProvider = new Actions(driver);
	}

	public boolean isElementExist(By locator) {
		return this.driver.findElements(locator).size() > 0;
	}

   
}
