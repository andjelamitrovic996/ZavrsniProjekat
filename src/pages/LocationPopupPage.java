package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
		
	}
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return driver.findElement(By.id("location_id"));
	}
	
	public WebElement getSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getCloseBtn() {
		return driver.findElement(By.xpath("//*[@id=\"location-popup\"]/div/div/div/div/a"));
	}
	
	
	
	public void openDialogFromHeader() {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[1]/div/a/i")).click();
	}

	public void setLocation(String locationName) {
		this.getKeyword().click();
	    this.getLocationItem(locationName).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", this.getSubmit());
		
	}
}
