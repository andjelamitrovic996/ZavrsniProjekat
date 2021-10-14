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
	
	public WebElement getConfirmationMsg() {
		return driver.findElement(By.className("system_message alert alert--success"));
	}
	
	public boolean confirmationMsg() {
		return this.isElementExist(By.className("system_message alert alert--success"));
		
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
