package com.ShopperStack.TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.annotations.Test;

import com.ShopperStack.GenericUtility.Base_Test;
import com.ShopperStack.Pom.Editaddress_Page;
import com.ShopperStack.Pom.My_Address_Page;
import com.ShopperStack.Pom.My_Profile_Page;

public class Check_if_UserIsAbleTO_UpadateAddress extends Base_Test {
	@Test
	public void updateAddress() throws IOException, InterruptedException, AWTException {
		homePage.getAccountSettingsBtn().click();
		Thread.sleep(2000);
		homePage.getMyProfileBtn().click();
		
		My_Profile_Page myProfilePage=new My_Profile_Page(driver);
		Thread.sleep(2000);
		myProfilePage.getMyAddressesBtn().click();

		My_Address_Page myAddressPage=new My_Address_Page(driver);
		Thread.sleep(2000);
		myAddressPage.getUpdateAddress().click();
		
		Editaddress_Page editAddress=new Editaddress_Page(driver);
		Robot rorbot=new Robot();
		
		editAddress.getNameTf().click();
		rorbot.keyPress(KeyEvent.VK_CONTROL);
		rorbot.keyPress(KeyEvent.VK_A);
		rorbot.keyRelease(KeyEvent.VK_CONTROL);
		editAddress.getNameTf().sendKeys(utility.readDataFromExcelFile("Sheet1", 2, 0));
		Thread.sleep(2000);
		
		editAddress.getHouseTf().click();
		rorbot.keyPress(KeyEvent.VK_CONTROL);
		rorbot.keyPress(KeyEvent.VK_A);
		rorbot.keyRelease(KeyEvent.VK_CONTROL);
		editAddress.getHouseTf().sendKeys(utility.readDataFromExcelFile("Sheet1", 2, 1));
		Thread.sleep(2000);
		
		editAddress.getStrretInfo().click();
		rorbot.keyPress(KeyEvent.VK_CONTROL);
		rorbot.keyPress(KeyEvent.VK_A);
		rorbot.keyRelease(KeyEvent.VK_CONTROL);
		editAddress.getStrretInfo().sendKeys(utility.readDataFromExcelFile("Sheet1", 2, 2));
		Thread.sleep(2000);
		
		editAddress.getLandmark().click();
		rorbot.keyPress(KeyEvent.VK_CONTROL);
		rorbot.keyPress(KeyEvent.VK_A);
		rorbot.keyRelease(KeyEvent.VK_CONTROL);
		editAddress.getLandmark().sendKeys(utility.readDataFromExcelFile("Sheet1", 2, 3));
		Thread.sleep(2000);
		
		editAddress.getCountry().click();
		Thread.sleep(2000);
		editAddress.getSelectCountry().click();
		Thread.sleep(2000);
		editAddress.getState().click();
		Thread.sleep(2000);
		editAddress.getSelectState().click();
		Thread.sleep(2000);
		editAddress.getCity().click();
		Thread.sleep(2000);
		editAddress.getSelectCity().click();
		Thread.sleep(2000);
		
		editAddress.getPincode().click();
		rorbot.keyPress(KeyEvent.VK_CONTROL);
		rorbot.keyPress(KeyEvent.VK_A);
		rorbot.keyRelease(KeyEvent.VK_CONTROL);
		editAddress.getPincode().sendKeys(utility.readDataFromExcelFile("Sheet1", 2, 4));
		Thread.sleep(2000);
	
		editAddress.getPhoneNumber().click();
		rorbot.keyPress(KeyEvent.VK_CONTROL);
		rorbot.keyPress(KeyEvent.VK_A);
		rorbot.keyRelease(KeyEvent.VK_CONTROL);
		editAddress.getPhoneNumber().sendKeys(utility.readDataFromExcelFile("Sheet1", 2, 5));
		Thread.sleep(2000);
		
		editAddress.getUpdateAddress().click();
	}
}