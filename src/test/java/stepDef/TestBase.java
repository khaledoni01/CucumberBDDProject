package stepDef;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LogInPageActions;

public class TestBase {

	public static WebDriver driver = null;

	/*
	 * Variables of action classes
	 */
	public static LogInPageActions logInPageActions = null;

	/*
	 * Object return methods of action classes
	 */

	
	@Before()
	public void scenarioStart() throws Throwable {
		
		this.openBrowser("chrome");

		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		logInPageActions = new LogInPageActions();
	}

	@After()
	public void scenarioEnd(Scenario scenario) throws Throwable {

		if (scenario.isFailed()) {


			String filePath = System.getProperty("user.dir") + "/screenshots/failed_" + scenario.getName() + ".png";
			
			TakesScreenshot scrShot = (TakesScreenshot) getDriver();
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File desFile = new File(filePath);
			try {
				FileUtils.copyFile(srcFile, desFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	public WebDriver openBrowser(String browserName) {
		WebDriver webDriver = null;

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions caps = new InternetExplorerOptions();
			caps.ignoreZoomSettings();
			caps.disableNativeEvents();
			webDriver = new InternetExplorerDriver(caps);
		}

		return webDriver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
