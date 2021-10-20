package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class BasicTest {
    protected WebDriver driver;
	protected ProfilePage profilePage;
	protected LocationPopupPage locationPage;
	protected LoginPage loginPage;
    protected AuthPage authPage;
    protected MealPage mealPage;
    protected CartSummaryPage cartSummaryPage;
    protected NotificationSystemPage notificationPage;
    
    
    
    
    
	

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		profilePage = new ProfilePage(driver);
		locationPage = new LocationPopupPage(driver);
		loginPage = new LoginPage(driver);
		authPage = new AuthPage(driver);
		mealPage = new MealPage(driver);
		cartSummaryPage = new CartSummaryPage(driver);
		notificationPage = new NotificationSystemPage(driver);
	}
	
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {

		Thread.sleep(1000);
		driver.quit();
		
	}
	
}
