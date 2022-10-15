package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utility.TestUtils;
import utility.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	static public Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;
	public static Logger print;
	public static Logger print1;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		print = Logger.getLogger("ajay");
	}
	
	public static void initialization() {
		String browser=prop.getProperty("browser");
		if(browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {		
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		e_driver =new EventFiringWebDriver(driver);
		eventListner=new WebEventListener();
		e_driver.register(eventListner);
		driver=e_driver;
		
		driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITE_WAIT, TimeUnit.SECONDS);
	}

}
