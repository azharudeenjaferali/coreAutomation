package com.aiite.pageexecution;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aiite.basepackage.BaseClass;
import com.aiite.pagefactory.HomePage;

public class HomePageExecution {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before HomePage");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After HomePage");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		BaseClass.browserLaunch();
	}
	
	@AfterMethod
	public void afterMethod() {
		BaseClass.closeBrowser();
	}
	
	@Test(priority=-1)
	public void tvSearch() {
		BaseClass.loadUrl("https://www.amazon.in/");
		HomePage hp = new HomePage();
		hp.searchBox.sendKeys("Television");
		hp.searchBtn.click();
		//Assertion
		System.out.println("Television Method - Executed");
	} 
	
	@Test
	public void mobileSearch() {
		BaseClass.loadUrl("https://www.amazon.in/");
		HomePage hp = new HomePage();
		hp.searchBox.sendKeys("Mobile");
		hp.searchBtn.click();
		Assert.assertTrue(false);
		System.out.println("Mobile Method - Executed");
	} 
	
	
	@Test(priority=-1,dependsOnMethods= {"mobileSearch"}, alwaysRun=true)
//	(enabled=true, dependsOnMethods= {"mobileSearch","tvSearch"})
	public void laptopSearch() {
		BaseClass.loadUrl("https://www.amazon.in/");
		HomePage hp = new HomePage();
		hp.searchBox.sendKeys("Laptop");
		hp.searchBtn.click();
		//Assertion
		System.out.println("Laptop Method - Executed");
	}
	
	
}
