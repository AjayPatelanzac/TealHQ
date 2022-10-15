package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utility.TestUtils;

public class ContactsPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	String sheetName= "Contacts";
	int contactNumber=1;
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		lp=new LoginPage();
		cp=new ContactsPage();
		System.out.println(driver.getCurrentUrl()+"setup");
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
		cp=hp.clickOnContacsLink();
		System.out.println(driver.getCurrentUrl()+"setup");

		
	}
	
	@Test(priority=1)
	public void contactsPageTitleTest() {
		String title=cp.verifyContactsPageTitle();
		Assert.assertEquals(title, "Teal - Contact Tracker","not matched login page title");
	}
	
	@Test(priority=2)
	public void contactsPageLogoTest() {
		boolean flag =cp.verifyContactsPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void addContactButtonTest() throws InterruptedException {
		cp.clickOnAddContactButton();
		
	}
	@DataProvider
	public Object[][] getContactExcelData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
		
	}
	@Test(priority = 4, dataProvider="getContactExcelData")
	public void createNewContactTest(String fn, String ln,String job, String company, String email, String linkedin, String twitter, String location, String phone ) throws InterruptedException {
		cp.clickOnAddContactButton();
		//driver.switchTo().frame(2);
		cp=cp.createNewContact(fn,ln,job,company,email,linkedin,twitter,location,phone);
		
	}
	@Test(priority =5)
	public void deleteContactTest() throws InterruptedException
	{
		cp.deleteContact(contactNumber);
		Thread.sleep(5000);
	}
	@Test(priority =6)
	public void deleteAllContactTest() throws InterruptedException
	{
		cp.deleteAllContacts();
		Thread.sleep(5000);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
