package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactsPage cl;


	public HomePageTest() {
		super();
		System.out.println("we are in home page");

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		lp=new LoginPage();
		cl=new ContactsPage();
		System.out.println(driver.getCurrentUrl()+"setup");
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));

	}

	@Test(priority=1)
	public void homePageTitleTest() {
		System.out.println(driver.getCurrentUrl()+"title");
		System.out.println("home page title Test");
		String title=hp.verifyHomePageTitle();
		Assert.assertEquals(title, "Teal - Home", "home page title is not matched");
	}

	@Test(priority=2)
	public void uTestLogoTest() {
		System.out.println(driver.getCurrentUrl()+"logo");
		System.out.println("logo test home page");
		Assert.assertTrue(hp.verifyHomePageLogo());
	}

	@Test(priority=3)
	public void clickOnCOntacsLinkTest() throws InterruptedException {
		cl =hp.clickOnContacsLink();

	}


	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


}
