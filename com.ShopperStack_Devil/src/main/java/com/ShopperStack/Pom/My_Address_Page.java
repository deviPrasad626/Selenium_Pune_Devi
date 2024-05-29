package com.ShopperStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Address_Page {
	public My_Address_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressesBtn;
	
	@FindBy(xpath = "(//*[name()='svg'])[6]")
	private WebElement updateAddress;
	
	
	
	@FindBy(xpath = "(//span[contains(@class,'MuiButton')])[2]")
	private WebElement deleteAddress;
	
	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement yes;
	
	
	public WebElement getAddAddressesBtn() {
		return addAddressesBtn;
	} 
	
	public WebElement getUpdateAddress() {
		return updateAddress;
	}
	public WebElement getDeleteAddress() {
		return deleteAddress;
	}
	public WebElement getYes() {
		return yes;
	}
}
