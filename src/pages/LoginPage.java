package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.name("password"));
	}

	public WebElement getRememberMeButton() {
		return driver.findElement(By.name("remember_me"));
	}
	
	public WebElement getForgotPasswordLink() {
		return driver.findElement(By.xpath("//*[@id=\"frm_fat_id_frmLogin\"]/p/a"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getLoginLink() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li[2]/a"));
	}
	
	public void clickLoginLink() {
		this.getLoginLink().click();
		
	}
	
	
	
	
	public void loginForm(String email, String password) {
		
		this.getEmailInput().clear();
		if (email != null) {
			this.getEmailInput().sendKeys(email);
		}
		this.getPasswordInput().clear();

		if (password != null) {
			this.getPasswordInput().sendKeys(password);
		}
		
		this.getRememberMeButton().click();
		this.getLoginButton().click();
	}
	
	
	
	
	
	
	
}
