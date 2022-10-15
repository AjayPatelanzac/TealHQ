package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public final class CompanyPage extends TestBase{

	@FindBy(xpath="//button[@class='ant-btn add-row-btn ant-btn-primary ant-btn-sm']")
	public List<WebElement> addaNewCompany;
	@FindBy(xpath = "//button[@class='ant-btn']") 
	public WebElement  addCompanyButtonFirst;


	@FindBy(xpath = "//img[@alt='Teal Logo']")
	public WebElement logo;


	@FindBy(id = "job-post_name") 
	public WebElement  companyName;
	@FindBy(id="job-post_industry")
	public WebElement  industry;
	@FindBy(id="job-post_company_size")
	public WebElement companySize;
	@FindBy(id="job-post_company_type")
	public WebElement companyType;
	
	
	@FindBy(id = "job-post_linked_in_url") 
	public WebElement  linkedinURL;
	@FindBy(className = "ant-form-item-control-input-content") 
	public WebElement  yearFound;
	@FindBy(id = "job-post_location") 
	public WebElement  location;
	@FindBy(id = "job-post_url") 
	public WebElement  website;
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
	public WebElement  addCompanyButton;
	List<WebElement> dropDownList;


	public CompanyPage() {
		PageFactory.initElements(driver, this);	
	}	

	public CompanyPage createNewCompany(String cn, String ind,String size, String type, String location, String website, String linkedin, String year) throws InterruptedException {
		companyName.sendKeys(cn);
		industry.click();
		dropDownList= driver.findElements(By.xpath("//div[@class='ant-select-item ant-select-item-option']"));
		for(WebElement option : dropDownList) {
		    if (option.getText().startsWith((ind.substring(0, 6)))) {
		        option.click();
		        Thread.sleep(1000);
		        break;
		    }
		}
		
		companySize.click();
		dropDownList= driver.findElements(By.xpath("//div[@class='ant-select-item ant-select-item-option']"));

		for(WebElement option : dropDownList) {
		    if (option.getText().startsWith((size.substring(0, 6)))) {
		        option.click();
		        Thread.sleep(1000);

		        break;
		    }
		}
		companyType.click();
		dropDownList= driver.findElements(By.xpath("//div[@class='ant-select-item ant-select-item-option']"));

		for(WebElement option : dropDownList) {
		    if (option.getText().startsWith((type.substring(0, 6)))) {
		        option.click();
		        Thread.sleep(1000);

		        break;
		    }
		}
		if(linkedin.length()>1) {
		linkedinURL.sendKeys(linkedin);}
		if(year.length()>1) {
		yearFound.sendKeys(year);}
		if(website.length()>1) {
		this.website.sendKeys(website);}
		if(location.length()>1) {
		this.location.sendKeys(location);}
		
		
		
		addCompanyButton.click();
		Thread.sleep(2000);
		return new CompanyPage();

	}

	public String verifyCompanyPageTitle()
	{
		System.out.println(driver.getCurrentUrl()+"from Company page");
		return driver.getTitle();
	}	

	public boolean verifyCompanyPageLogo() {
		return logo.isDisplayed();
	}

	public void clickOnAddCompanyButton() throws InterruptedException {
		if(addaNewCompany.size()>0) {
			addaNewCompany.get(0).click();;
		}else{			
			
			addCompanyButtonFirst.click();}

		Thread.sleep(1000);
		//return new CreateCompanyPage();
	}
	public void deleteCompany(int selectCompanyToDelete) throws InterruptedException {

		//checkBox1.click();

		if(checkBox.isDisplayed()) {	
			checkBox.click();
			Thread.sleep(2000);
			deleteButton.click();
			Thread.sleep(2000);
			confirmDeleteButton.click();}
		else {
			System.out.println("there is no Company on this number");
		}

	}
	public void deleteAllCompany() throws InterruptedException {
		if(deleteAllCheckBox.isDisplayed()) {
			deleteAllCheckBox.click();			
			Thread.sleep(2000);
			if(deleteButton.isDisplayed()) {
				deleteButton.click();
				Thread.sleep(2000);

				confirmDeleteButton.click();}
			else {
				System.out.println("there is no Company");
			}

		}
	}
	public String searchCompany() {
		return null;
		
	}
	

}

