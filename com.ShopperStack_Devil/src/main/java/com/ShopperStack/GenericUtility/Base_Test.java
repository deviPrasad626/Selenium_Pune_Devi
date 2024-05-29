package com.ShopperStack.GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ShopperStack.Pom.Home_Page;
import com.ShopperStack.Pom.Login_Page;
import com.ShopperStack.Pom.My_Address_Page;
import com.ShopperStack.Pom.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test {
	public WebDriver driver;
	public static WebDriver listnerDriver;
	public FileUtility utility=new FileUtility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public Webdriver_Utility webUtility=new Webdriver_Utility();
	public Java_Utility javaUtility=new Java_Utility();
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Befor Suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Befor Test");
		spark=new ExtentSparkReporter(FrameworkConstants.reportPath+javaUtility.localDateTime()+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
		test=report.createTest("Demo");
	}
	@BeforeClass
	public void beforeClass() throws IOException {
		
		System.out.println("Beforee Class");
		String browser=FrameworkConstants.chromeValue;
		String url=utility.readDataFromPropertyFile("url");
		if(browser.contains("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}else if (browser.contains("edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("Enter Valid Browser");
		}
		listnerDriver=driver;
		welcomePage=new Welcome_Page(driver);
		loginPage=new Login_Page(driver);
		homePage=new Home_Page(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(url);
	}
	@BeforeMethod
	public void beforeMethods() throws IOException, InterruptedException {
		System.out.println("Before method");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",welcomePage.getLoginBtn());
		Thread.sleep(2000);
		loginPage.getEmailTB().sendKeys(utility.readDataFromPropertyFile("username"));
		Thread.sleep(2000);
		loginPage.getPasswordTB().sendKeys(utility.readDataFromPropertyFile("password"));
		Thread.sleep(2000);
		loginPage.getLoginBtn().click();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("After Method");
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",homePage.getAccountSettingsBtn());
		Thread.sleep(2000);
		homePage.getLogoutBtn().click();
		
	}
	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("After Class");
		Thread.sleep(3000);
		driver.quit();
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		report.flush();
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("After Suite");
	}
}
