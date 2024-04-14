package com.DDF.DemowebShop.Test;

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

import com.DDF.DemowebShop.pages.AddToCart;
import com.DDF.DemowebShop.pages.Billing;
import com.DDF.DemowebShop.pages.LogOut;
import com.DDF.DemowebShop.pages.Login;
import com.DDF.DemowebShop.pages.Payment;
import com.DDF.DemowebShop.pages.Register;
import com.DDF.DemowebShop.pages.Shiping;

public class DemoWebshop_Test {
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

	@Test(priority = 1, dataProvider = "getData")
	public void registerTest(String fname, String lname, String email, String pass) {
		Register reg = PageFactory.initElements(driver, Register.class);
		reg.registerCheck(fname, lname, email, pass);
		log.info("Registration Successful with DataProvider");
	}

	@Test(priority = 2)
	public void logOut() {
		LogOut lOut = PageFactory.initElements(driver, LogOut.class);
		lOut.logout();
	}

	@Test(priority = 3, dataProvider = "getLoginData")
	public void loginCheckWithExcel(String user, String pass) {
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginCheck(user, pass);
		log.info("Login Successful with DataProvider");
	}

	@Test(priority = 4)
	public void addProduct() throws InterruptedException {
		AddToCart cart = PageFactory.initElements(driver, AddToCart.class);
		cart.addproduct();
	}

	@Test(priority = 5, dataProvider = "getBillingData")
	public void Billingdetails(String comp, String contry, String city, String adr1, String adr2, String pcode,
			String ph, String fax) {
		Billing bill = PageFactory.initElements(driver, Billing.class);
		bill.biling(comp, contry, city, adr1, adr2, pcode, ph, fax);
	}

	@Test(priority = 6)
	public void shiping() {
		Shiping ship = PageFactory.initElements(driver, Shiping.class);
		ship.Ship();
	}
	@Test(priority = 7)
	public void payment() {
		Payment pay = PageFactory.initElements(driver, Payment.class);
		pay.confirmOrder();
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
	public Object[][] getData() {
		return new Object[][] { new Object[] { "Sudha", "Murthy", "SudhaM1225@gmail.com", "SudhaM@123"

				} };
	}

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] { new Object[] { "SudhaM1225@gmail.com", "SudhaM@123"

				} };
	}

	@DataProvider
	public Object[][] getBillingData() {
		return new Object[][] {
				new Object[] { "Infosys", "India", "Pune", "Akurdi", "GkAssociates", "411033", "98765434345", "34567"

				} };
	}

}
