package com.aiite.basepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public static WebDriver driver;
	
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public static String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public static WebElement searchElementById(String id){
		return driver.findElement(By.id(id));
	}
	
	public static WebElement searchElementByXpath(String xpath){
		return driver.findElement(By.xpath(xpath));
	}
	
	public static void closeBrowser() {
		driver.close();
	}
}
