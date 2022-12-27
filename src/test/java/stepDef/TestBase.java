package stepDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;

import bsh.util.Util;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.CommonClass;
import pageObjects.LogInPageActions;
import pageObjects.RegistrationPageActions;
import testUtil.CommonUtil;
import testUtil.Utility;

public class TestBase {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LogManager.getLogger();
	private Utility util = new Utility();

	/*
	 * Variables of action classes
	 */
	private CommonUtil commonUtil = null;
	private CommonClass commonClass = null;

	public static ThreadLocal<LogInPageActions> logInPageActions = new ThreadLocal<LogInPageActions>();
	private RegistrationPageActions registrationPageActions = null;

	/*
	 * Object return methods of action classes
	 */

	public RegistrationPageActions registrationPageActionsObject(WebDriver driver) {
		if (this.registrationPageActions == null) {
			this.registrationPageActions = new RegistrationPageActions(driver);
		}
		return this.registrationPageActions;
	}

	public CommonClass commonClassObject() {
		if (this.commonClass == null) {
			this.commonClass = new CommonClass();
		}
		return this.commonClass;
	}

	public CommonUtil commonUtilObject() {
		if (this.commonUtil == null) {
			this.commonUtil = new CommonUtil();
		}
		return this.commonUtil;
	}
	
	@Before("@sanity")
	public void scenarioStart() throws Throwable {
		String browser = util.propertiesFile(util.getPropFilePath()).getProperty("browser");
		
		driver.set(this.openBrowser(browser));
		logger.info(browser + " Browser is Launched");

		driver.get().manage().deleteAllCookies();
		driver.get().get(util.propertiesFile(util.getPropFilePath()).getProperty("baseURL"));
//		driver.manage().window().maximize();

		logInPageActions.set(new LogInPageActions(driver.get()));
	}

	@After("@sanity")
	public void scenarioEnd(Scenario scenario) throws Throwable {

		if (scenario.isFailed()) {

			String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

			String filePath = System.getProperty("user.dir") + "/screenshots/failed_" + scenario.getName() + ".png";
			
			TakesScreenshot scrShot = (TakesScreenshot) getDriver();
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File desFile = new File(filePath);
			try {
				FileUtils.copyFile(srcFile, desFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// add screenshot to cucumber adapter html report
			byte[] fileContent = FileUtils.readFileToByteArray(srcFile);
			String base64File = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(base64File);
		}

		if (driver.get() != null) {
			driver.get().close();
			driver.get().quit();
		}
		driver.set(null);
		logger.info(util.propertiesFile(util.getPropFilePath()).getProperty("browser") + " Driver is closed");
	}

	public WebDriver openBrowser(String browserName) {
		WebDriver webDriver = null;

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/browser/chromedriver_85.exe");
			webDriver = new ChromeDriver();
		} 
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/browser/IEDriverServer_32.exe");
			InternetExplorerOptions caps = new InternetExplorerOptions();
			caps.ignoreZoomSettings();
			caps.disableNativeEvents();
			webDriver = new InternetExplorerDriver(caps);
		}

		logger.info(browserName + " Driver is Initiated");
		return webDriver;
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

}
