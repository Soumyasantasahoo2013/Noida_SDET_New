package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriverUtility wUtil=new WebDriverUtility();
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organisationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;

	/**
	 * @return the organisationLink
	 */
	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	/**
	 * @return the adminstratorIMG
	 */
	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}

	/**
	 * @return the signOutLink
	 */
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	/**
	 * This method is used to click on Organisation Link
	 */
	public void clickOnOrganisationLink() {
		organisationLink.click();
	}
	
	public void signOut() {
		mouseOver(driver, adminstratorIMG);
		signOutLink.click();
	}

}
