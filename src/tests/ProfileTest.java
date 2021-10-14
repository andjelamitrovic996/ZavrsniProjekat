package tests;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest {
	
	private WebDriver driver;
	private ProfilePage profilePage;
	private LocationPopupPage locationPage;
	private LoginPage loginPage;
    private AuthPage authPage;
    
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		profilePage = new ProfilePage(driver);
		locationPage = new LocationPopupPage(driver);
		loginPage = new LoginPage(driver);
		authPage = new AuthPage(driver);
	}

	@Test
	public void loginWithValidCredentials() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		locationPage.getCloseBtn().click();
		loginPage.loginForm("customer@dummyid.com", "12345678a");
		profilePage.profilePage();
//		Assert.assertEquals(loginPage.confirmationMsg(), true, "Usuccsessful login.");
		profilePage.profileSettingsForm("Andjela", "Mitrovic", "Address", "123456789", "5055");
		Thread.sleep(500);
		profilePage.selectCountry("United States");
		Thread.sleep(500);
		profilePage.selectState("California");
		Thread.sleep(500);
		profilePage.selectCity("Los Angeles");
		Thread.sleep(500);
		profilePage.getSubmitBtn();
		profilePage.getSubmitBtn().click();
		profilePage.setProfilePic();
//		authPage.getOpenDialogBtn().click();
//		authPage.logout();
		
		
	}
	

}
