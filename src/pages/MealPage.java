package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getRecepies() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[1]/div/ul/li[2]/a"));
	}
	
	public void recepiesPage() {
		this.getRecepies().click();
	}
	
	public WebElement getMeal() {
		return driver.findElement(By.xpath("//*[@id=\"body\"]/section[1]/div[2]/div/div/div[1]/div/a[2]/img"));
	}
	
	
	
	public void viewMeal() {
		this.getMeal().click();
	}
	
	public void addMealToFavourite() {
		driver.findElement(By.className("svg-icn")).click();
	}
	
	
	public WebElement getAddMealToCartBtn() {
	   return driver.findElement(By.xpath("//*[@id=\"body\"]/section[1]/div/div/div[2]/div/div[3]/div[2]/a"));
	}
	
	public WebElement getQuantityInput() {
		return driver.findElement(By.name("product_qty"));
	}
	
	
	public void setQuantity(String quantity) {
		this.getQuantityInput().sendKeys(quantity);
	}
	
	
	
	public void clickAddMealToCartBtn() {
		this.getAddMealToCartBtn().click();
	}
	
	

}
