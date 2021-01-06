package com.grootan.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.grootan.qa.base.TestBase;


public class HomePage extends TestBase{
	
	@FindBy(linkText="Home")
	public WebElement home;
	
	@FindBy(linkText="Services")
	public WebElement services;
	
	@FindBy(linkText="Open Source")
	public WebElement openSource;
	
	@FindBy(linkText="Blog")
	public WebElement blog;
	
	@FindBy(linkText="Team")
	public WebElement team;
	
	@FindBy(linkText="Careers")
	public WebElement careers;
	
	@FindBy(linkText="Contact Us")
	public WebElement contactUs;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnHomeLink() {
		home.click();
	}
	
	public void clickOnServicesLink() {
		services.click();
	}
	
	public void clickOnOpenSourceLink() {
		openSource.click();
	}
	
	public void clickOnBlogLink() {
		blog.click();
	}
	
	public void clickOnTeamLink() {
		team.click();
	}
	
	public void clickOnCareersLink() {
		careers.click();
	}
	
	public void clickOnContactUsLink() {
		contactUs.click();
	}

}
