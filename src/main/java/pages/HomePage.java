package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	@CacheLookup
	@FindBy(className="user-initials")
	public WebElement userName;
	@CacheLookup
	@FindBy(xpath = "//img[@alt='Teal Logo']")
	public WebElement logo;
	@CacheLookup
	@FindBy(xpath  = "//*[contains(text(),'Contacts')]")
	public WebElement contactLink;
	@FindBy(xpath  = "//*[contains(text(),'Companies')]")
	public WebElement companyLink;
	

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	
	}	
	
	public String verifyHomePageTitle()
	{
		System.out.println(driver.getCurrentUrl()+"from home page");
		return driver.getTitle();
		
	}
	
	
	public boolean verifyHomePageLogo() {
		// TODO Auto-generated method stub
		return logo.isDisplayed();
	}
	
	public ContactsPage clickOnContacsLink() throws InterruptedException {
		contactLink.click();
		Thread.sleep(2000);
		return new ContactsPage();
	}

	public CompanyPage clickOnCompanyLink() throws InterruptedException {
		companyLink.click();
		Thread.sleep(2000);
		return new CompanyPage();
		
	}

	
	
	

}
