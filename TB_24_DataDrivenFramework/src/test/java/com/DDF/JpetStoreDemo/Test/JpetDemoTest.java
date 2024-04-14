package com.DDF.JpetStoreDemo.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DDF.DemowebShop.Test.DemoWebshop_Test;
import com.DDF.DemowebShop.pages.AddToCart;
import com.DDF.JpetStoreDemo.pages.AccountFormPage;
import com.DDF.JpetStoreDemo.pages.AddToCartPge;
import com.DDF.JpetStoreDemo.pages.ConfirmOrder;
import com.DDF.JpetStoreDemo.pages.LoginPage;

public class JpetDemoTest {
	WebDriver driver;
	static Logger log = Logger.getLogger(DemoWebshop_Test.class.getName());

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserExe/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	@Parameters({ "url" })

	public void UrlLaunch(String url) {
		driver.get(url);
	}

	@BeforeClass
	public void cookies() {
		driver.manage().getCookies();
	}

	@BeforeMethod
	public void manage() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "accountForm", priority = 1)

	public void fillAcform(String usernm, String pass, String fname, String lname, String phn, String adr1, String adr2,
			String city, String state, String zip, String country, String laung, String categ) {
		AccountFormPage formPage = PageFactory.initElements(driver, AccountFormPage.class);

		formPage.accountInfo(usernm, pass, fname, lname, phn, adr1, adr2, city, state, zip, country, laung, categ);
	}

	@Test(priority = 2, dataProvider = "loginData")
	public void loginAccount(String us, String pas) {
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.LoginToAccount(us, pas);
	}

	@Test(priority = 3)
	public void addTocart() {
		AddToCartPge product = PageFactory.initElements(driver, AddToCartPge.class);
		product.checkoutProcess();
	}

	@Test(priority = 4, dataProvider = "getBillingData")
	public void ConfirmMyOrder(String card, String cdno, String exp, String fn, String ln, String ad1, String ad2,
			String citynm, String statnm, String zipCode, String contry) throws InterruptedException {

		ConfirmOrder order = PageFactory.initElements(driver, ConfirmOrder.class);
		order.billingpage(card, cdno, exp, fn, ln, ad1, ad2, citynm, statnm, zipCode, contry);
	}

	@AfterMethod
	public void ScreenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("src/test/resources/ScreenShot"));
	}

	@AfterClass
	public void DeleteCookie() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void closeConnections() {
		log.info("Connections Are closed");
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] accountForm() {
		return new Object[][] { new Object[] { "AbdulKalam29@gmail.com", "APJ@123", "Abdul", "Kalam", "987654234",
				"Baner", "GK", "Pune", "Maharahtra", "45673", "India", "German", "Birds" } };

	}

	@DataProvider
	public Object[][] loginData() {
		return new Object[][] { new Object[] { "AbdulKalam29@gmail.com", "APJ@123"

				} };
	}

	@DataProvider
	public Object[][] getBillingData() {
		return new Object[][] { new Object[] { "MasterCard", "2345678799", "22/11", "Abdul", "Kalam", "Baner", "GK",
				"Pune", "Maharahtra", "45673", "India"

				} };
	}
}
