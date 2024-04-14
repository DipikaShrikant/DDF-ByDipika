package com.DDF.DemowebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddToCart {
	WebDriver driver;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")
	WebElement addtocart;
	@FindBy(xpath = "//a[@class=\"ico-cart\"]//child::span")
	WebElement shopingcart;
	@FindBy(css = "input[value=\"Go to cart\"]")
	WebElement gotocart;
	
	@FindBy(xpath="//input[@id=\"termsofservice\"]")
	WebElement agree;
	
	@FindBy(css = "button[name=\"checkout\"]")
	WebElement checkout;

	public AddToCart(WebDriver driver) {
		this.driver = driver;
	}

	public void addproduct() throws InterruptedException {
		addtocart.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(shopingcart);
		act.moveToElement(gotocart).build().perform();
		gotocart.click();
		agree.click();
		checkout.click();
	}
}
