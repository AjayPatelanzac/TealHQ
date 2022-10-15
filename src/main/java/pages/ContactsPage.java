package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public final class ContactsPage extends TestBase{
	@CacheLookup
	@FindBy(xpath="//button[@class='ant-btn add-row-btn ant-btn-primary ant-btn-sm']")
	public WebElement addaNewContacts;
	@CacheLookup
	@FindBy(xpath = "//button[@class='ant-btn']") 
	public List<WebElement>  addContactButtonFirst;


	@FindBy(xpath = "//img[@alt='Teal Logo']")
	public WebElement logo;


	@FindBy(id = "job-post_first_name") 
	public WebElement  firstName;
	@FindBy(id = "job-post_last_name") 
	public WebElement  lastName;
	@FindBy(id = "job-post_current_job_title") 
	public WebElement  jobTitle;
	@FindBy(id = "job-post_current_job_company") 
	public WebElement  companyName;
	@FindBy(id = "job-post_email") 
	public WebElement  email;
	@FindBy(id = "job-post_linked_in_url") 
	public WebElement  linkedinURL;
	@FindBy(id = "job-post_twitter_handle") 
	public WebElement  twitterURL;
	@FindBy(id = "job-post_current_job_location") 
	public WebElement  location;
	@FindBy(id = "job-post_phone") 
	public WebElement  phone;
	//span[@aria-label='delete']
	@FindBy(xpath="//button[@class='ant-btn ant-btn-sm ant-btn-dangerous']")
	public WebElement deleteButton;

	@FindBy(xpath="//button[@class='ant-btn ant-btn-danger']")
	public WebElement confirmDeleteButton;

	@FindBy(xpath="(//div[@class='formatterCell'])")
	public WebElement checkBox;
	@FindBy(xpath="//label[@class='ant-checkbox-wrapper']")
	public WebElement deleteAllCheckBox;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary']") 
	public WebElement  addContactButton;



	public ContactsPage() {
		PageFactory.initElements(driver, this);	
	}	

	public String verifyContactsPageTitle()
	{
		System.out.println(driver.getCurrentUrl()+"from contaact page");
		return driver.getTitle();
	}	

	public boolean verifyContactsPageLogo() {
		return logo.isDisplayed();
	}

	public CreateContactsPage clickOnAddContactButton() throws InterruptedException {
					
			if(addContactButtonFirst.size()>0) {
			addContactButtonFirst.get(0).click();}
			else {
				addaNewContacts.click();
			}

		Thread.sleep(1000);
		return new CreateContactsPage();
	}



	public ContactsPage createNewContact(String fn, String ln,String job, String company, String email, String linkedin, String twitter, String location, String phone) throws InterruptedException {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		this.email.sendKeys(email);
		companyName.sendKeys(company);
		linkedinURL.sendKeys(linkedin);
		twitterURL.sendKeys(twitter);
		this.location.sendKeys(location);
		this.phone.sendKeys(phone);
		jobTitle.sendKeys(job);
		addContactButton.click();
		Thread.sleep(2000);
		return new ContactsPage();

	}
	public void deleteContact(int selectContactToDelete) throws InterruptedException {

		//checkBox1.click();

		if(checkBox.isDisplayed()) {	
			checkBox.click();
			Thread.sleep(2000);
			deleteButton.click();
			Thread.sleep(2000);
			confirmDeleteButton.click();}
		else {
			System.out.println("there is no contact on this number");
		}

	}
	public void deleteAllContacts() throws InterruptedException {
		if(deleteAllCheckBox.isDisplayed()) {
			deleteAllCheckBox.click();			
			Thread.sleep(2000);
			if(deleteButton.isDisplayed()) {
				deleteButton.click();
				Thread.sleep(2000);

				confirmDeleteButton.click();}
			else {
				System.out.println("there is no contact");
			}

		}
	}
	public String searchContact() {
		return null;
		
	}
	

}

