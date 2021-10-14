package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage {

	
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getProfilePage() {
		return driver.findElement(By.xpath("//*[@id=\"fixed__panel\"]/ul/li[2]/a"));
	}
	
	
	public WebElement getFirstNameInput() {
		return driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastNameInput() {
		return driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddressInput() {
		return driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhoneInput() {
		return driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCodeInput() {
		return driver.findElement(By.name("user_zip"));
	}
	
	public void selectCountry(String countryName) {
		Select drpCountry = new Select(driver.findElement(By.name("user_country_id")));
		drpCountry.selectByVisibleText(countryName);
	}
	
	public void selectState(String stateName) {
		Select drpState = new Select (driver.findElement(By.name("user_state_id")));
		drpState.selectByVisibleText(stateName);
	}
	
	public void selectCity(String cityName) {
		Select drpCity = new Select (driver.findElement(By.name("user_city")));
		drpCity.selectByVisibleText(cityName);
	}
	
	public WebElement getSubmitBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getImgArea() {
		return driver.findElement(By.className("avatar"));
	}
	
	public WebElement getImgUploadBtn() {
		return driver.findElement(By.className("ion-camera"));
	}
	public void setProfilePic() throws InterruptedException, AWTException {
	  actionProvider.moveToElement(this.getImgArea()).build().perform();
	  this.getImgUploadBtn().click();
	  Thread.sleep(1000);
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_ESCAPE);
	  robot.keyRelease(KeyEvent.VK_ESCAPE);
	  String imgPath = new File("img/profile.pic.jpg").getAbsolutePath();
	  WebElement upload_file = driver.findElement(By.xpath("//input[@type='file']"));

	  upload_file.sendKeys(imgPath);
	  Thread.sleep(500);
	  
	}
	
	public void profilePage() {
		this.getProfilePage().click();
	}
	
	public void profileSettingsForm(String firstName, String lastName, String address, String phone, String zipCode) {
		this.getFirstNameInput().clear();
		this.getFirstNameInput().sendKeys(firstName);
		this.getLastNameInput().clear();
		this.getLastNameInput().sendKeys(lastName);
		this.getAddressInput().clear();
		this.getAddressInput().sendKeys(address);
		this.getPhoneInput().clear();
		this.getPhoneInput().sendKeys(phone);
		this.getZipCodeInput().clear();
		this.getZipCodeInput().sendKeys(zipCode);
		}

}
