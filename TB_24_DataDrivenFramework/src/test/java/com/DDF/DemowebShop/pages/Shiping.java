package com.DDF.DemowebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Shiping {
	WebDriver driver;
	@FindBy(xpath = "//input[@name=\"PickUpInStore\"][1]")
	WebElement pickUp;
	@FindBy(css = "input[onclick=\"Shipping.save()\"]")
	WebElement ShipcontBtn;

	public Shiping(WebDriver driver) {
		this.driver = driver;
	}

	public void Ship() {
		pickUp.click();
		ShipcontBtn.click();
	}
}
