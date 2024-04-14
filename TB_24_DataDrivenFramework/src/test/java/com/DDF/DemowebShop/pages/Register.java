package com.DDF.DemowebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register {

	WebDriver driver;

	@FindBy(xpath = "//input[@id=\"gender-female\"]")
	WebElement gender;

	@FindBy(name = "FirstName")
	WebElement fname;
	@FindBy(name = "LastName")
	WebElement lname;
	@FindBy(name = "Email")
	WebElement email;
	@FindBy(name = "Password")
	WebElement pass;
	@FindBy(name = "ConfirmPassword")
	WebElement cpass;
	@FindBy(name = "register-button")
	WebElement register;

	public Register(WebDriver driver) {
		this.driver = driver;
	}

	public void registerCheck(String fnm, String lnm, String eml, String pas) {
		gender.click();
		fname.sendKeys(fnm);
		lname.sendKeys(lnm);
		email.sendKeys(eml);
		pass.sendKeys(pas);
		cpass.sendKeys(pas);
		register.click();

	}
}
