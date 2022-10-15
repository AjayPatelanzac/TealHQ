package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CompanyPage;
import pages.HomePage;
import pages.LoginPage;
import utility.TestUtils;

public class CompanyPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	CompanyPage cp;
	String sheetName= "Company";
	int companyNumber=1;
	public CompanyPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		lp=new LoginPage();
		cp=new CompanyPage();
		System.out.println(driver.getCurrentUrl()+"setup");
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
		cp=hp.clickOnCompanyLink();
		System.out.println(driver.getCurrentUrl()+"setup");

		
	}
	
	@Test(priority=1)
	public void CompanyPageTitleTest() {
		String title=cp.verifyCompanyPageTitle();
		Assert.assertEquals(title, "Teal - Company Tracker");
	}
	
	@Test(priority=2)
	public void CompanyPageLogoTest() {
		boolean flag =cp.verifyCompanyPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void addCompanyButtonTest() throws InterruptedException {
		cp.clickOnAddCompanyButton();
		
	}
	@DataProvider
	public Object[][] getCompanyExcelData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
		
	}
	@Test(priority = 4, dataProvider="getCompanyExcelData")
	public void createNewCompanyTest(String cn, String ind,String size, String type, String location, String website, String linkedin, String year) throws InterruptedException {
		cp.clickOnAddCompanyButton();
		//driver.switchTo().frame(2);
		cp=cp.createNewCompany(cn,ind,size,type,location,website,linkedin,year);
		
	}
	@Test(priority =5)
	public void deleteCompanyTest() throws InterruptedException
	{
		cp.deleteCompany(companyNumber);
		Thread.sleep(5000);
	}
	@Test(priority =6)
	public void deleteAllCompanyTest() throws InterruptedException
	{
		cp.deleteAllCompany();
		Thread.sleep(5000);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
