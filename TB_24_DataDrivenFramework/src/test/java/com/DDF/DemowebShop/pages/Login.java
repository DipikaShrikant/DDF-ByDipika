package com.DDF.DemowebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class=\"ico-login\"]")
	WebElement logInBtn;
	
	@FindBy(name="Email")
	WebElement usernm;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(name="RememberMe")
	WebElement RememberMeBtn;
	
	@FindBy(xpath ="//input[@class=\"button-1 login-button\"]")
	WebElement login;

	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginCheck(String user,String pass) {
		logInBtn.click();
		usernm.sendKeys(user);
		password.sendKeys(pass);
		RememberMeBtn.click();
		login.click();
	}

}
