package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericUtils.BaseClass;
import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.PropertyUtility;
import com.crm.GenericUtils.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganisationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganisationPage;

public class CreateOrganisationTest extends BaseClass{
	
	@Test
	public void createOrganisationTest() throws Throwable
	{
		//WebDriverUtility wUtil=new WebDriverUtility();
		
		//PropertyUtility pUtil=new PropertyUtility();
		String URL=pUtil.getPropertyKeyValue("url");
		String USERNAME=pUtil.getPropertyKeyValue("username");
		String PASSWORD=pUtil.getPropertyKeyValue("password");
		
		//ExcelUtility eUtil=new ExcelUtility();
		String orgName=eUtil.getExcelData("Sheet1", "TC_02", "IndustryType")+ JavaUtility.getRandomData();
		
		//Launch the browser
		//WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		wUtil.waitUntilPageLoad(driver);
		
		//Get URL
		//driver.get(URL);
		
		//Login into the application
		//LoginPage lp=new LoginPage(driver);
		//lp.login(USERNAME, PASSWORD);
		
		//Navigate to Organisation
		wUtil.waitUntilPageLoad(driver);
		hp=new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		//Navigate to Create Organisation
		OrganisationPage orgPage=new OrganisationPage(driver);
		orgPage.clickOnCreateOrganisationImg();
		
		//Create Organisation
		CreateOrganisationPage createOrgPage=new CreateOrganisationPage(driver);
		createOrgPage.createOrganization(orgName);
	}

}
