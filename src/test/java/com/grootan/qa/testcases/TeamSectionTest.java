package com.grootan.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.grootan.qa.base.TestBase;
import com.grootan.qa.pages.HomePage;
import com.grootan.qa.pages.TeamPage;
import com.grootan.qa.util.TestUtil;


public class TeamSectionTest extends TestBase{

	HomePage homePage;
	TeamPage teamPage;

	public TeamSectionTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage =new HomePage();
		teamPage =new TeamPage();
		homePage.clickOnTeamLink();
	}

	@Test(priority=1)
	public void printJuniorEngineerNamesFromTeamcSectionInTOExcel() {
		System.out.println("There are "+ teamPage.JuniorEngineer.size()  +" JuniorEngineer in the Team Section and theres name are printed in excel");
		TestUtil.writeJuniorEngineersNamesInToExcel(teamPage.printJuniorsEngineersNames());
	}

	@Test(priority=2)
	public void compareHrAndCTO_CoFounderImages() {
		Assert.assertFalse(TestUtil.compareHrAndCTO_CoFounderImage(teamPage.founderImage(), teamPage.hrImage()), "Images are not similar");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

