package com.DDF.DemowebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOut {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class=\"ico-logout\"]")
	WebElement logOutBtn ;

	public LogOut(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout() {
		
		logOutBtn.click();
	}
	
	
}
