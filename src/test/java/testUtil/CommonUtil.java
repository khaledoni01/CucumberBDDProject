package testUtil;

import java.time.Duration;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class CommonUtil {
	
	private Logger logger = LogManager.getLogger();
	
	private WebDriverWait wait = null;
	private final int WAIT_TIME = 20;
	
	

	// ===================================
	// Keep all the common functionalities in this class as 
	// ===================================

	
	public void log(String logInfo) {
		logger.info(logInfo);
	}	
	public void assertTrue(boolean condition, String msg) {
		this.log(msg);
		Assert.assertTrue(condition, msg);
	}
	public void assertFalse(boolean condition, String msg) {
		this.log(msg);
		Assert.assertFalse(condition, msg);
	}
	public void assertEquals(boolean actual, boolean expected, String msg) {
		this.log(msg);
		Assert.assertEquals(actual, expected, msg);
	}	
	public void inputKeysToEle(WebElement ele, String val) {
		ele.clear();
		ele.sendKeys(val);
	}
	public void inputKeysWithEnterToEle(WebElement ele, String val) {
		ele.clear();
		ele.sendKeys(val + Keys.ENTER);
	}
	
	public void clickEle(WebElement ele) {
		ele.click();
	}
	public void clickEleJsExec(WebDriver driver, WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}
	public void clickEleAction(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).click().build().perform();
	}
	public void clickEleOffsetAction(WebDriver driver, int x, int y) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(x, y).click().build().perform();
	}
	public void submitEle(WebElement ele) {
		ele.submit();
	}
	public Select selectEleFromDropDown(WebElement ele) {
		Select sel = new Select(ele);
		return sel;
	}
	public String getTextOfEle(WebElement ele) {
		String val = ele.getText().trim();
		return val;
	}
	public String getInnerHTMLOfEle(WebElement ele) {
		String val = ele.getAttribute("innerHTML").trim();
		return val;
	}
	public String getJSHTMLOfEle(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String val = (String) jse.executeScript("return arguments[0].innerHTML", ele);
		return val;
	}
	public String getJSTextOfEle(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String val = (String) jse.executeScript("return arguments[0].innerText", ele);
		return val;
	}
	public String getAttributeOfEle(WebElement ele, String attrName) {
		String val = ele.getAttribute(attrName).trim();
		return val;
	}
	public void sleep(long miliSec) {
		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void waitDriverUntilExpectedNumberOfWindows(WebDriver driver, int expectedNumberOfWindows) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
	}	
	public void waitDriverUntilElementIsVisible(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitDriverUntilElementIsClickable(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitDriverUntilNoOfElement(WebDriver driver, By locator) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	public void waitDriverUntilNoOfElement(WebDriver driver, By locator, int num) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, num));
	}
	public void waitDriverUntilAttrToBe(WebDriver driver, WebElement ele, String attrName, String attrValue) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.attributeToBe(ele, attrName, attrValue));
	}
	public void waitDriverUntilElementIsInvisible(WebDriver driver, WebElement ele) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void waitDriverUntilAttrValueOfElement(WebDriver driver, WebElement ele, String attrName,
			String attrVal) {
		wait = new WebDriverWait(driver, WAIT_TIME);
		wait.until(ExpectedConditions.attributeToBe(ele, attrName, attrVal));
	}
	public WebElement waitDriverUsingFluent(WebDriver driver, final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(WAIT_TIME))
				.pollingEvery(Duration.ofSeconds(WAIT_TIME)).ignoring(NoSuchElementException.class);

		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return ele;
	}
	public void verifyPageHeader(String actualHeader, WebElement ele) {
		Assert.assertEquals(actualHeader, this.getTextOfEle(ele),
				"'" + actualHeader + "' Title is not validated");
		this.log("Client has landed on '" + actualHeader + "' page");
	}
	public void scrollIntoView(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	public void scrollToTheBottom(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void navigateTo(WebDriver driver, String url) {
		
		if (!driver.getCurrentUrl().equals(url)) {
			driver.navigate().to(url);
			this.log("Navigated to " + url);
		} 
		else {
			this.log("Current URL is equal to provided URL");
		}		
	}	
	public  String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	public boolean startsWith(String fullStr, String str) {
		boolean bool = false;
		int len = str.length();
		String startTxt = fullStr.substring(0, len);

		if (startTxt.equalsIgnoreCase(str)) {
			bool = true;
		} else {
			bool = false;
		}
		return bool;
	}
	public static synchronized boolean endsWith(String fullStr, String str) {
		boolean bool = false;
		int len = str.length();
		String endTxt = fullStr.substring(fullStr.length() - len);

		if (endTxt.equalsIgnoreCase(str)) {
			bool = true;
		} else {
			bool = false;
		}
		return bool;
	}

}
