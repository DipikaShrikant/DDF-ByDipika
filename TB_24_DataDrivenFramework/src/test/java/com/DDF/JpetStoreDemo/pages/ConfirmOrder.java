package com.DDF.JpetStoreDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ConfirmOrder {
	WebDriver driver;

	@FindBy(css = "select[name=\"cardType\"]")
	WebElement cardType;

	@FindBy(css = "input[name=\"creditCard\"]")
	WebElement creditcardNo;

	@FindBy(name = "expiryDate")
	WebElement expdt;

	@FindBy(name = "billToFirstName")
	WebElement fname;

	@FindBy(name = "billToLastName")
	WebElement lname;

	@FindBy(name = "billAddress1")
	WebElement adr1;

	@FindBy(name = "billAddress2")
	WebElement adr2;

	@FindBy(name = "billCity")
	WebElement city;

	@FindBy(name = "billState")
	WebElement state;

	@FindBy(name = "billZip")
	WebElement zip;

	@FindBy(name = "billCountry")
	WebElement cont;

	@FindBy(xpath = "//button[@type='submit' and text()='Continue']")
	WebElement contBtn;
	
	@FindBy(xpath="//div[@class=\"button-bar\"]//child::button[@type=\"submit\"]")
	WebElement confirm;
	
	@FindBy(xpath="//div[@id=\"MessageBar\"]")
	WebElement confirmMsg;

	public ConfirmOrder(WebDriver driver) {
		this.driver = driver;
	}

	public void billingpage(String card, String cdno, String exp, String fn, String ln, String ad1, String ad2,
			String citynm, String statnm, String zipCode, String contry) throws InterruptedException {
		Select sel = new Select(cardType);
		sel.selectByVisibleText(card);
Thread.sleep(1000);
		creditcardNo.clear();
		creditcardNo.sendKeys(cdno);

		expdt.clear();
		expdt.sendKeys(exp);
		fname.clear();
		fname.sendKeys(fn);

		lname.clear();
		lname.sendKeys(ln);

		adr1.clear();
		adr1.sendKeys(ad1);

		adr2.clear();
		adr2.sendKeys(ad2);

		city.clear();
		city.sendKeys(citynm);

		state.clear();
		state.sendKeys(statnm);

		zip.clear();
		zip.sendKeys(zipCode);
		
		cont.clear();
		cont.sendKeys(contry);
		contBtn.click();
		
		confirm.click();
		
		String text = confirmMsg.getText();
		System.out.println(text);
	}

}
