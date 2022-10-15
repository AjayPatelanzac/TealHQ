package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	//Page Factory 
	@CacheLookup
	@FindBy(id="login_email")
	public WebElement email;
	@CacheLookup
	@FindBy(id = "login_password")
	public WebElement password;
	@CacheLookup
	@FindBy(id = "register-submit")
	public WebElement signInButton;
	@CacheLookup
	@FindBy(className = "teal-logo")
	public WebElement logo;
	
	
	
	@FindBy(linkText  = "Forgot Password?")
	public WebElement forgotPasswordLink;
	
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		//System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public  boolean validateUTTestLogo() {
		//System.out.println(logo.isDisplayed());
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pws) throws InterruptedException {
		email.sendKeys(un);
		password.sendKeys(pws);
		//Thread.sleep(2000);
		signInButton.click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl()+"from login page");
		return new HomePage();
		
	}
	
	public void userClickOnLink(String arg1) {
		WebElement headerLink=driver.findElement(By.partialLinkText(arg1));
		headerLink.click();				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
