package com.DDF.DemowebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payment {
	WebDriver driver;
	

	@FindBy(xpath = "//input[@value=\"Payments.CashOnDelivery\"]")
	WebElement Cod;

	@FindBy(xpath = "//input[@class=\"button-1 payment-method-next-step-button\"]")
	WebElement paymethod;

	@FindBy(xpath = "//input[@class=\"button-1 payment-info-next-step-button\"]")
	WebElement payInfo;

	@FindBy(xpath = "//input[@class=\"button-1 confirm-order-next-step-button\"]")
	WebElement confirm;
	@FindBy(xpath = "//div[@class=\"page-title\"]")
	WebElement title;

	@FindBy(xpath = "//input[@class=\"button-2 order-completed-continue-button\"]")
	WebElement orderDetails;

	public Payment(WebDriver driver) {
		this.driver = driver;
	}
	
	public void confirmOrder() {
		Cod.click();
		paymethod.click();
		payInfo.click();
		confirm.click();
		title.isDisplayed();
		String text = title.getText();
		System.out.println(text);
		orderDetails.click();
	}
}
