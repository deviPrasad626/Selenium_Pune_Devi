package com.ShopperStack.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ShopperStack.GenericUtility.Base_Test;
import com.ShopperStack.Pom.Address_Form_Page;
import com.ShopperStack.Pom.My_Address_Page;
import com.ShopperStack.Pom.My_Profile_Page;

public class Check_whether_User_Is_Able_To_Add_Address_Test extends Base_Test {
	@Test
	public void addAddress() throws IOException, InterruptedException {
		homePage.getAccountSettingsBtn().click();
		Thread.sleep(2000);
		homePage.getMyProfileBtn().click();
		
		My_Profile_Page myProfilePage=new My_Profile_Page(driver);
		Thread.sleep(2000);
		myProfilePage.getMyAddressesBtn().click();
		
		My_Address_Page myAddressPage=new My_Address_Page(driver);
		Thread.sleep(2000);
		myAddressPage.getAddAddressesBtn().click();
		
		Address_Form_Page addressForm=new Address_Form_Page(driver);
		Thread.sleep(2000);
		addressForm.getOfficeRBtn().click();
		
		addressForm.getNameTf().sendKeys(utility.readDataFromExcelFile("Sheet1", 1, 0));
		Thread.sleep(1000);
		addressForm.getHouseTf().sendKeys(utility.readDataFromExcelFile("Sheet1", 1, 1));
		Thread.sleep(1000);
		addressForm.getStreetTf().sendKeys(utility.readDataFromExcelFile("Sheet1", 1, 2));
		Thread.sleep(1000);
		addressForm.getLandMark().sendKeys(utility.readDataFromExcelFile("Sheet1", 1, 3));
		
		webUtility.selectByValue(addressForm.getCountry(),utility.readDataFromPropertyFile("country"));
		Thread.sleep(1000);
		webUtility.selectByValue(addressForm.getState(),utility.readDataFromPropertyFile("state"));
		Thread.sleep(1000);
		webUtility.selectByValue(addressForm.getCity(),utility.readDataFromPropertyFile("city"));
		
		Thread.sleep(1000);
		addressForm.getPincodeTf().sendKeys(utility.readDataFromExcelFile("Sheet1", 1, 4));
		Thread.sleep(1000);
		addressForm.getPhoneNumberTf().sendKeys(utility.readDataFromExcelFile("Sheet1", 1, 5));
		Thread.sleep(2000);
		addressForm.getAddAddressBtn().click();	
	}
}
