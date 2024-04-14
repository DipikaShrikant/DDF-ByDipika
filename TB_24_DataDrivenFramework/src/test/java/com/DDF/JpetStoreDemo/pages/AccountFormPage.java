package com.DDF.JpetStoreDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountFormPage {

	WebDriver driver;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "repeatedPassword")
	WebElement cpass;

	@FindBy(name = "firstName")
	WebElement fname;

	@FindBy(name = "lastName")
	WebElement lname;

	@FindBy(name = "email")
	WebElement email;
	@FindBy(name = "phone")
	WebElement phone;

	@FindBy(name = "address1")
	WebElement adr1;

	@FindBy(name = "address2")
	WebElement adr2;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "zip")
	WebElement zip;
	@FindBy(name = "country")
	WebElement contry;

	@FindBy(name = "languagePreference")
	WebElement laung;

	@FindBy(name = "favouriteCategoryId")
	WebElement categ;

	@FindBy(name = "listOption")
	WebElement listopt;

	@FindBy(name = "bannerOption")
	WebElement banneropt;

	@FindBy(xpath = "//div[@class=\"button-bar\"]//child::button")
	WebElement button;

	public AccountFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void accountInfo(String uname, String pass, String fn, String ln, String phn, String ad1,
			String ad2, String citynm, String statenm, String zipc, String cont, String lan, String catg) {

		username.sendKeys(uname);
		password.sendKeys(pass);
		cpass.sendKeys(pass);
		fname.sendKeys(fn);
		lname.sendKeys(ln);
		email.sendKeys(uname);
		phone.sendKeys(phn);
		adr1.sendKeys(ad1);
		adr2.sendKeys(ad2);
		city.sendKeys(citynm);
		state.sendKeys(statenm);
		zip.sendKeys(zipc);
		contry.sendKeys(cont);
		Select sel = new Select(laung);
		sel.selectByVisibleText(lan);
		
		Select sel2 = new Select(categ);
		sel2.selectByVisibleText(catg);
		listopt.click();
		banneropt.click();
		button.click();
		
		

	}

}
