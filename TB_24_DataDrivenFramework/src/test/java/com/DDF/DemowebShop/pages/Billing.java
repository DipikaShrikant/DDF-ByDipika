package com.DDF.DemowebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Billing {
	WebDriver driver;
	
	@FindBy (id="BillingNewAddress_Company22")
	WebElement compny;
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement contry;
	@FindBy (id="BillingNewAddress_City")
	WebElement city;
	@FindBy (id="BillingNewAddress_Address1")
	WebElement adr1;
	@FindBy (id="BillingNewAddress_Address2")
	WebElement adr2;
	@FindBy (id="BillingNewAddress_ZipPostalCode")
	WebElement pcode;
	@FindBy (id="BillingNewAddress_PhoneNumber")
	WebElement phn;
	@FindBy (id="BillingNewAddress_FaxNumber")
	WebElement faxno;
	@FindBy (css = "input[onclick=\"Billing.save()\"]")
	WebElement contBtn;
	
	
	public Billing(WebDriver driver) {
		this.driver = driver;
	}

	
	public void biling(String compNm,String cont,String cityad, String ad1,String ad2,
			String zip,String phnNo,String fax) {
		
		compny.sendKeys(compNm);
		Select sel= new Select(contry);
		sel.selectByVisibleText(cont);
		city.sendKeys(cityad);
		adr1.sendKeys(ad1);
		adr2.sendKeys(ad2);
		pcode.sendKeys(zip);
		phn.sendKeys(phnNo);
		faxno.sendKeys(fax);
		contBtn.click();
	}
	
	

}
