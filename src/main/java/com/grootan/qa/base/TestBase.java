package com.grootan.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.grootan.qa.util.TestUtil;
import com.grootan.qa.util.WebEventListener;

public class TestBase {

	public static Properties prop;
	public static FileInputStream in;
	public static WebDriver driver;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;

	public TestBase() {

		try{
			in = new FileInputStream(System.getProperty("user.dir")
					+"/src/main/java/com/grootan/qa/config/config.properties");
			prop = new Properties();
			prop.load(in);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+"/src/main/java/com/grootan/qa/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
					+"/src/main/java/com/grootan/qa/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		eventListener = new WebEventListener();
		e_driver = new EventFiringWebDriver(driver);
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}
