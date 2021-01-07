package com.grootan.qa.testcases;


import org.automationtesting.excelreport.Xl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grootan.qa.base.TestBase;
import com.grootan.qa.pages.HomePage;
import com.grootan.qa.pages.TeamPage;
import com.grootan.qa.util.TestUtil;


public class GrootanTest extends TestBase {

	HomePage homePage;
	TeamPage teamPage;

	public GrootanTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		teamPage = new TeamPage();
	}

	@Test(priority=1)
	public void click_On_HomeSection_And_TakeScreenshot() {
		homePage.clickOnHomeLink();
		TestUtil.takeScreenshot(homePage.home.getText());
	}

	@Test(priority=2)
	public void click_On_ServicesSection_And_TakeScreenshot() {
		homePage.clickOnServicesLink();
		TestUtil.takeScreenshot(homePage.services.getText());
	}

	@Test(priority=3)
	public void click_On_OpenSourceSection_And_TakeScreenshot() {
		homePage.clickOnOpenSourceLink();
		TestUtil.takeScreenshot(homePage.openSource.getText());
	}

	@Test(priority=4)
	public void click_On_BlogSection_And_TakeScreenshot() {
		homePage.clickOnBlogLink();
		TestUtil.takeScreenshot(homePage.blog.getText());
	}

	@Test(priority=5)
	public void click_On_TeamcSection_And_TakeScreenshot() {
		homePage.clickOnTeamLink();
		TestUtil.takeScreenshot(homePage.team.getText());
	}

	@Test(priority=6)
	public void click_On_CareersSection_And_TakeScreenshot() {
		homePage.clickOnCareersLink();
		TestUtil.takeScreenshot(homePage.careers.getText());
	}

	@Test(priority=7)
	public void click_On_ContactUSSection_And_TakeScreenshot() {
		homePage.clickOnContactUsLink();
		TestUtil.takeScreenshot(homePage.contactUs.getText());
	}

	/*@Test(priority=8)
	public static void compareFolder1AndFolder2() {
		TestUtil.compareFolder1AndFolder2();
	}*/

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	/*@AfterSuite
	public void reportGeneration() throws Exception {
		Xl.generateReport(System.getProperty("user.dir")+"/Output", "ExcelReport.xlsx");
	}*/
}












