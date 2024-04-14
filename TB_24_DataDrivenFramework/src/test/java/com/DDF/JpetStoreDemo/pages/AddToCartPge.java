package com.DDF.JpetStoreDemo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPge {
	WebDriver driver;
	
	@FindBy(xpath="//a[@href=\"/categories/BIRDS\"]")
	WebElement birds;
	
	@FindBy(xpath="//a[@href=\"/products/AV-CB-01\"]")
	WebElement productno;
	
	@FindBy(xpath="//a[@href=\"/cart/addItemToCart?itemId=EST-18\"]")
	WebElement addtoCart;
	
	@FindBy(css="input[name=\"EST-18\"]")
	WebElement quantity;
	
	@FindBy(xpath="//button[@type='submit' and text()='Update Cart']")
	WebElement updatecart;
	
	@FindBy(xpath="//a[@href=\"/order/newOrderForm\"]")
	WebElement checkout;

	public AddToCartPge(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkoutProcess() {
		
		birds.click();
		productno.click();
		addtoCart.click();
		
		quantity.clear();
		quantity.sendKeys("2");
		updatecart.click();
		checkout.click();
	}

}
