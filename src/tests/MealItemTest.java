package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {
	
	

	@Test (priority = 1)
	public void addMealToCartTest() throws InterruptedException {
		locationPage.getCloseBtn().click();
		mealPage.clickAddMealToCartBtn();
		Thread.sleep(5000);
	//	String actualString1 = notificationPage.getConfirmationMsg().getText();
	//	Assert.assertTrue(actualString1.contains("The Following Errors Occurred:" 
	//	                 + "Please Select Location"));
		locationPage.openDialogFromHeader();
		locationPage.setLocation("City Center - Albany");
		Thread.sleep(500);
		mealPage.clickAddMealToCartBtn();
		Thread.sleep(1000);
		String actualString = notificationPage.getConfirmationMsg().getText();
		Assert.assertTrue(actualString.contains("Meal Added To Cart"));
		
	}
	
	@Test (priority = 2)
	public void addMealToFavouriteTest() throws InterruptedException {
	locationPage.getCloseBtn().click();
	Thread.sleep(500);
    mealPage.addMealToFavourite();
	Thread.sleep(1000);
	String actualString2 = notificationPage.getConfirmationMsg().getText();
	Assert.assertTrue(actualString2.contains("Please login first!"));
	Thread.sleep(5000);
	loginPage.clickLoginLink();
	loginPage.loginForm("customer@dummyid.com", "12345678a");
	Thread.sleep(5000);
	mealPage.addMealToFavourite();
	Thread.sleep(1000);
	String actualString = notificationPage.getConfirmationMsg().getText();
	Assert.assertTrue(actualString.contains("Product has been added to your favorites."));
	
	}
	
	@Test (priority = 3)
	public void clearCartTest() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		locationPage.getCloseBtn().click();
		Thread.sleep(500);
		driver.get("http://demo.yo-meals.com/meals");
		locationPage.openDialogFromHeader();
	    locationPage.setLocation("City Center - Albany");
		Thread.sleep(1000);
		
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet meals = wb.getSheet("Meals");
		
		for (int i = 1; i <= meals.getLastRowNum(); i++) {
			
			String mealUrl = meals.getRow(i).getCell(0).getStringCellValue();
			
			driver.get(mealUrl);
			mealPage.clickAddMealToCartBtn();
			
//			softAssert.assertTrue(notificationPage.getConfirmationMsg().contains("Meals Added To Cart"));
					
			
			
		}
		
	//	softAssert.assertAll();
		Thread.sleep(1000);
		
		
//		Assert.assertTrue(notificationPage.getConfirmationMsg().contains("All meals removed from Cart successfully"));

		
		cartSummaryPage.clearAll();
		wb.close();
		
	}
	
	
}
