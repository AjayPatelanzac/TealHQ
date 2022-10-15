package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp=null;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
		//System.out.println("we are in login page");

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		System.out.println("Teal");
		String title=lp.validateLoginPageTitle();
		Assert.assertEquals(title, "Teal","not matched login page title");
	}
	
	@Test(priority=2)
	public void uTestLogoTest() {
		System.out.println("logo test");
		boolean flag =lp.validateUTTestLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		System.out.println("entered email password");
		homePage=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println(driver.getCurrentUrl()+"from login test");
	}
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
