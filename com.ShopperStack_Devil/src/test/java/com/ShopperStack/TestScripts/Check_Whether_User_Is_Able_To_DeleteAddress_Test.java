package com.ShopperStack.TestScripts;

import org.testng.annotations.Test;

import com.ShopperStack.GenericUtility.Base_Test;
import com.ShopperStack.Pom.My_Address_Page;
import com.ShopperStack.Pom.My_Profile_Page;

public class Check_Whether_User_Is_Able_To_DeleteAddress_Test extends Base_Test{
	@Test
	public void deleteAddress() throws InterruptedException {
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();
		
		My_Profile_Page myProfilePage=new My_Profile_Page(driver);
		myProfilePage.getMyAddressesBtn().click();
		
		My_Address_Page myAddressPage=new My_Address_Page(driver);
		myAddressPage.getDeleteAddress().click();
		Thread.sleep(2000);
		myAddressPage.getYes().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
}
