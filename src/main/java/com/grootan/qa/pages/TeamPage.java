package com.grootan.qa.pages;

import java.awt.image.BufferedImage;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.grootan.qa.base.TestBase;
import com.grootan.qa.util.TestUtil;

public class TeamPage extends TestBase{

	@FindBy(xpath="//*[@src='img/testimonials/lokesh.jpg']")
	public WebElement CTO_CoFounderImage;

	@FindBy(xpath="//*[@src='img/testimonials/sasi.jpg']")
	public WebElement HRManagerImage;

	@FindBy(xpath="//*[text()='Junior Engineer']//preceding-sibling::h3")
	public List<WebElement> JuniorEngineer;


	public TeamPage() {
		PageFactory.initElements(driver, this);
	}

	public BufferedImage founderImage() {
		return TestUtil.aShot(CTO_CoFounderImage);		
	}

	public BufferedImage hrImage() {
		return TestUtil.aShot(HRManagerImage);		
	}

	public String[] printJuniorsEngineersNames() {
		String[] JuniorsEngineersName = new String[JuniorEngineer.size()];
		for(int i=0;i<JuniorEngineer.size();i++) {
			JuniorsEngineersName[i] = JuniorEngineer.get(i).getText();
		}
		return JuniorsEngineersName;
	}
}
