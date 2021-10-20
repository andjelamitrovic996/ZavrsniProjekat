package tests;

import java.awt.AWTException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{
	

	@Test(priority = 1)
	public void editProfileTest() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		locationPage.getCloseBtn().click();
		loginPage.loginForm("customer@dummyid.com", "12345678a");
		Thread.sleep(1000);
		String actualString1 = notificationPage.getConfirmationMsg().getText();
		Assert.assertTrue(actualString1.contains("Login Successfull"));
		profilePage.profilePage();
		profilePage.profileSettingsForm("Andjela", "Mitrovic", "Address", "123456789", "5055");
		Thread.sleep(1000);
		profilePage.selectCountry("United States");
		Thread.sleep(1000);
		profilePage.selectState("California");
		Thread.sleep(1000);
		profilePage.selectCity("Los Angeles");
		Thread.sleep(1000);
		profilePage.clickSaveBtn();
		Thread.sleep(1000);
		String actualString2 = notificationPage.getConfirmationMsg().getText();
		Assert.assertTrue(actualString2.contains("Setup Successful"));
		Thread.sleep(5000);
		authPage.getOpenDialogBtn().click();
		authPage.logout();
		String actualString3 = notificationPage.getConfirmationMsg().getText();
		Assert.assertTrue(actualString3.contains("Logout Successfull!"));
	}
	
	@Test(priority = 2)
	public void changeProfileImgTest() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		locationPage.getCloseBtn().click();
		loginPage.loginForm("customer@dummyid.com", "12345678a");
		Thread.sleep(1000);
		String actualString1 = notificationPage.getConfirmationMsg().getText();
		Assert.assertTrue(actualString1.contains("Login Successfull"));
		profilePage.profilePage();
		profilePage.profileSettingsForm("Andjela", "Mitrovic", "Address", "123456789", "5055");
		Thread.sleep(1000);
		profilePage.setProfilePic();
	    Thread.sleep(1000);
	    String actualString2 = notificationPage.getConfirmationMsg().getText();
	    Assert.assertTrue(actualString2.contains("Profile Image Uploaded Successfully"));
	    profilePage.deleteProfilePic();
	    Thread.sleep(1000);
	    String actualString3 = notificationPage.getConfirmationMsg().getText();
	    Assert.assertTrue(actualString3.contains("Profile Image Deleted Successfully"));
	    Thread.sleep(5000);
	    authPage.getOpenDialogBtn().click();
		authPage.logout();
		Thread.sleep(5000);
		String actualString4 = notificationPage.getConfirmationMsg().getText();
		Assert.assertTrue(actualString4.contains("Logout Successfull!"));
	}

}
