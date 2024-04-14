package com.DDF.JpetStoreDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class=\"button-bar\"]//child::button[@class=\"button\"]")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LoginToAccount(String user,String pass) {
		uname.clear();
		uname.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		
		loginBtn.click();
	}

}
