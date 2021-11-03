package demo.actimeGenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import demo.actiTime.POM.HomePage;
import demo.actiTime.POM.LoginPage;

public class BaseClass { 
	/**
	 * 
	 */
	
	WebDriver driver = null;
	PropertyUtils pUtils = new PropertyUtils();

	
	@BeforeSuite
	public void configBS() {
		//database connection, extend report, loggers
	}
	
	@BeforeTest
	public void configBT() {
		//parallel testing codes
	}
	
	@BeforeClass
	public void configBC() {
		//open the browser
		String browserName = pUtils.getPropertyData(IPathConstants.PROPFILE_PATH, "browser");
		String url = pUtils.getPropertyData(IPathConstants.PROPFILE_PATH, "url");
		
		if(browserName.equals("chrome")) {
			System.setProperty(IPathConstants.CHROME_KEY, IPathConstants.CHROME_PATH);
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty(IPathConstants.FIREFOX_KEY, IPathConstants.FIREFOX_PATH);
			driver=new FirefoxDriver();
		}
		else {
			throw new SessionNotCreatedException("Browser is not Supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IPathConstants.IMP_TIME, TimeUnit.SECONDS);
		driver.get(IPathConstants.URL_KEY);
	}
	
	@BeforeMethod
	public void configBM() {
		
	//login to the site
		LoginPage loginPage = new LoginPage(driver);
		String username = pUtils.getPropertyData(IPathConstants.PROPFILE_PATH, IPathConstants.UN_KEY);
		String password = pUtils.getPropertyData(IPathConstants.PROPFILE_PATH, IPathConstants.PWD_KEY);

		loginPage.login(username, password);		
	}
	
	@AfterMethod
	public void configAM() {
		
	//logout from the site
		HomePage homePage = new HomePage(driver);
		homePage.clickOnlogout();
	}
	
	@AfterClass
	public void configAC() {
		
	//close the browser
		driver.quit();
	}
	
	
	@AfterTest
	public void configAT() {
		//close all the parallel connection
	}
	
	@AfterSuite
	public void configAS() {
		//close data connection
	}
}
