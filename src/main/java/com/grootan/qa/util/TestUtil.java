package com.grootan.qa.util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.frontendtest.components.ImageComparison;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import org.testng.Reporter;

import com.grootan.qa.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;

	static String target;
	static File des;
	static File outputFile1;
	static File outputFile2;
	static String targetFolder1;
	static String targetFolder2;
	static FileOutputStream fio;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static void writeJuniorEngineersNamesInToExcel(String[] names) {

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("JuniorEngineers");
		try {
			fio = new FileOutputStream(System.getProperty("user.dir")+"/Output/JuniorEngineers.xlsx");
			for(int i=0;i<names.length;i++) {
				sheet.createRow(i).createCell(0).setCellValue(names[i]);;
			}
			workbook.write(fio);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void takeScreenshot(String name) {

		outputFile1 = new File(System.getProperty("user.dir")+"/Folder1/");
		String st = outputFile1.getAbsolutePath();
		targetFolder1 = st +"/" + name +".png";

		outputFile2 = new File(System.getProperty("user.dir")+"/Folder2/");
		String str= outputFile2.getAbsolutePath();
		targetFolder2 = str +"/" + name +".png";


		TakesScreenshot ta = (TakesScreenshot) driver;
		File source = ta.getScreenshotAs(OutputType.FILE);

		des = new File(targetFolder1);
		if(!des.exists()) {
			outputFile1.mkdirs();
			try {
				System.out.println("Screenshot taken for "+name+ ",saved in Folder1");
				FileHandler.copy(source, des);
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
		}
		else {
			outputFile2.mkdirs();
			try {
				FileHandler.copy(source, new File(targetFolder2));
				System.out.println("Screenshot taken for "+name+ ",saved in Folder2");			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		Reporter.log("<br><img src='"+targetFolder1+"' height='400' width='400'/><br>");
	}

	public static void compareFolder1AndFolder2() {
		if(outputFile2.exists()) {
			if(targetFolder2.equalsIgnoreCase(targetFolder1)) {
				ImageComparison comp = new ImageComparison(20, 20, 0.15);
				try {
					if(comp.fuzzyEqual(targetFolder1, targetFolder2, System.getProperty("user.dir")+".png")){
						System.out.println("Images are Similar in Folder1 and Folder2");
					}
					else {
						System.out.println("Images are not Similar in Folder1 and Folder2");
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Boolean compareHrAndCTO_CoFounderImage(BufferedImage image1, BufferedImage image2) {

		ImageDiffer imgDiff = new ImageDiffer();
		Boolean diff = imgDiff.makeDiff(image1, image2).hasDiff();
		return diff;
	}

	public static BufferedImage aShot(WebElement image) {

		Screenshot screenshot = new AShot().takeScreenshot(driver, image);
		BufferedImage snap = screenshot.getImage();
		return snap;			
	}
}

