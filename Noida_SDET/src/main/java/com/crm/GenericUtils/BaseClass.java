package com.crm.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public ExcelUtility eUtil=new ExcelUtility();
	public PropertyUtility pUtil=new PropertyUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
    public HomePage hp;

	@BeforeSuite(groups = {"smokeTest" , "regressionTest"})
	public void configBS() {
		//connect to DB
	}

	@BeforeTest(groups = {"smokeTest" , "regressionTest"})
	public void configBT() {
		//launch browser in parallel mode
	}

	//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest" , "regressionTest"})
	public void configBC() throws Throwable {
		String browserName=pUtil.getPropertyKeyValue("browser");

		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	@BeforeMethod(groups = {"smokeTest" , "regressionTest"})
	public void setUp() throws Throwable {
		String url=pUtil.getPropertyKeyValue("url");
		String username=pUtil.getPropertyKeyValue("username");
		String password=pUtil.getPropertyKeyValue("password");
		driver.get(url);
		//login to the application
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(username, password);
	}

	@AfterMethod(groups = {"smokeTest" , "regressionTest"})
	public void tearDown() throws Throwable {
		wUtil.waitForElementVisibility(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		hp.signOut();
	}

	@AfterClass(groups = {"smokeTest" , "regressionTest"})
	public void configAC() {
		driver.quit();
	}

	@AfterTest(groups = {"smokeTest" , "regressionTest"})
	public void configAT() {
		//close driver ref in parallel mode
	}

	@AfterSuite(groups = {"smokeTest" , "regressionTest"})
	public void configAS() {
		// close DB connection
	}


}
